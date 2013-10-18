/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manage.complex.util;

/**
 *
 * @author anantha
 */
public class NotAuthenticatedException extends Exception{

    public NotAuthenticatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(cause);
    }

    public NotAuthenticatedException(Throwable cause) {
        super(cause);
    }

    public NotAuthenticatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAuthenticatedException(String message) {
        super(message);
    }

    public NotAuthenticatedException() {
    }
    
    
    
}
