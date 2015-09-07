/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.util;

import br.com.codigof.iguana.beans.UsuariosFacade;
import br.com.codigof.iguana.jpa.entities.Usuarios;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author thiago
 */
@ManagedBean
@SessionScoped
public class Login {

    private static final Logger LOGGER = Logger.getLogger(Usuarios.class.toString());

    public static final String HOME_PAGE_REDIRECT = "/secured/home.xhtml?faces-redirect=true";
    public static final String LOGOUT_PAGE_REDIRECT = "/logout.xhtml?faces-redirect=true";

    private String userId;
    private String userPassword;
    private Usuarios currentUser;
    
    @EJB
    private br.com.codigof.iguana.beans.UsuariosFacade ejbFacade;

    public UsuariosFacade getEjbFacade() {
        return ejbFacade;
    }

    public String login() {
        // lookup the user based on user name and user password
        currentUser = find(userId, userPassword);

        if (currentUser != null) {
//            LOGGER.info("login successful for '{}'", userId);

            return HOME_PAGE_REDIRECT;
        } else {
//            LOGGER.info("login failed for '{}'", userId);
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Login failed",
                            "Invalid or unknown credentials."));

            return null;
        }
    }

    public String logout() {
        String identifier = userId;

        // invalidate the session
//        LOGGER.debug("invalidating session for '{}'", identifier);
        FacesContext.getCurrentInstance().getExternalContext()
                .invalidateSession();

//        LOGGER.info("logout successful for '{}'", identifier);
        return LOGOUT_PAGE_REDIRECT;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public String isLoggedInForwardHome() {
        if (isLoggedIn()) {
            return HOME_PAGE_REDIRECT;
        }

        return null;
    }

    private Usuarios find(String login, String password) {
        Usuarios result = null;

        // code block to be replaced with actual retrieval of user
//        if ("john.doe".equalsIgnoreCase(userId)
//                && "1234".equals(password)) {
//            result = new Usuarios(userId, "John", "Doe");
//        }
//        if(ejbFacade.findByLoginAndPassword(login, Criptography.md5(password))){
//            
//        }

        return result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Usuarios getCurrentUser() {
        return currentUser;
    }

    // do not provide a setter for currentUser!
}