/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.waa.group9.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesUtil {
    
    public static void displayError(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage errMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, message);
        context.addMessage(null, errMsg);
    }
}
