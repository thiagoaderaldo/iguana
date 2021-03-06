package br.com.codigof.iguana.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtils {


    public static void mensInfo(String clientId,String message) {
        mensagem(clientId,message, FacesMessage.SEVERITY_INFO);
    }


    public static void mensErro(String clientId,String message) {
        mensagem(clientId,message, FacesMessage.SEVERITY_ERROR);
    }

    public static void mensagem(String clientId,String message,
    		FacesMessage.Severity severity) {
    	
        FacesContext.getCurrentInstance().
        	addMessage(clientId, new FacesMessage(severity, message, null));
    }
    
    public static String get(String param) {
    	
    	return (String) FacesContext.getCurrentInstance().
			getExternalContext().
			getRequestParameterMap().get(param);
    }   

}
