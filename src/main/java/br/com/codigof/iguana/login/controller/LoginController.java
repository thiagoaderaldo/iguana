/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.login.controller;

import br.com.codigof.iguana.beans.UsuariosFacade;
import br.com.codigof.iguana.jpa.entities.Usuarios;
import br.com.codigof.iguana.util.HashGenerator;
import java.security.NoSuchAlgorithmException;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author thiago
 */
@SessionScoped  
@ManagedBean  
public class LoginController {  
    private Usuarios user;  
  
    @EJB  
    private UsuariosFacade userFacade; 
    
    private String username, password;
      
    private static final String INDEX = "/admin/index.jsf?faces-redirect=true";    
      
    private static final String STAY_IN_THE_SAME_PAGE = null;   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
    @PostConstruct  
    public void init(){    
        user = new Usuarios();    
    }
      
    public Usuarios getUser(){  
        if(user == null || user.getLogin() == null){  
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();  
            if (context.getUserPrincipal() != null){  
                String userLogin = context.getUserPrincipal().getName();  
  
                user = userFacade.findByLogin(userLogin);  
            }  
        }  
  
        return user;  
    }  
      
    public void setUser(Usuarios usuario) {    
        this.user = usuario;    
    }    
  
    public boolean isUserAdmin(){  
        return getRequest().isUserInRole("admin");  
    }  
      
    public boolean isUserLoggedIn(){  
          
        if (getContext().getExternalContext().getUserPrincipal() != null)  
            return true;  
          
        return false;  
          
    }  
  
    public String logOut(){  
        //getRequest().getSession().invalidate();  
        try {  
            getRequest().logout();  
              
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
        user = new Usuarios();  
        return "/login.jsf";  
    }  
  
    private HttpServletRequest getRequest() {  
        return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();  
    }  
      
        
    public String login() throws NoSuchAlgorithmException{   
          
          
        try {  
              
            if (getContext().getExternalContext().getUserPrincipal() == null){
//                getRequest().login(user.getLogin(), user.getSenha()); 
                getRequest().login(getUsername(), getPassword()); 
                System.out.println("Passou por aqui na hora do login");
            }  
                
              
            return INDEX;   
  
        } catch (Exception e) {  
              
                sendErrorMessageToUser("form-login", "Não foi possível se logar.", "Login ou senha inválidos.");
                System.out.println("Erro: " + e.getMessage());
              
            return STAY_IN_THE_SAME_PAGE;    
        }
            finally{
//            System.out.println("Login: " + user.getLogin() + "\nSenha: " + HashGenerator.md5(user.getSenha()));
            System.out.println("Login: " + getUsername() + "\nSenha: " + getPassword());
            System.out.println("Tipo de autenticação: \n" + getRequest().getAuthType());
        }   
          
    }    
    
//    public String login() {
//        // lookup the user based on user name and user password
//        //currentUser = find(userId, userPassword);
//
//        if (user != null) {
////            LOGGER.info("login successful for '{}'", userId);
//
//            return INDEX;
//        } else {
////            LOGGER.info("login failed for '{}'", userId);
//            FacesContext.getCurrentInstance().addMessage(
//                    null,
//                    new FacesMessage(FacesMessage.SEVERITY_WARN,
//                            "Login failed",
//                            "Invalid or unknown credentials."));
//
//            return null;
//        }
//    }
    
    private void sendInfoMessageToUser(String title, String message){  
        FacesContext context = getContext();  
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));  
    }  
      
    private void sendInfoMessageToUser(String messageBox, String title, String message){  
        FacesContext context = getContext();  
        context.addMessage(messageBox, new FacesMessage(FacesMessage.SEVERITY_INFO, title, message));  
    }  
  
    private void sendErrorMessageToUser(String title, String message){  
        FacesContext context = getContext();  
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));  
    }  
      
    private void sendErrorMessageToUser(String messageBox, String title, String message){  
        FacesContext context = getContext();  
        context.addMessage(messageBox, new FacesMessage(FacesMessage.SEVERITY_ERROR, title, message));  
    }  
  
    private FacesContext getContext() {  
        FacesContext context = FacesContext.getCurrentInstance();  
        return context;  
    }  
  
  
}  
