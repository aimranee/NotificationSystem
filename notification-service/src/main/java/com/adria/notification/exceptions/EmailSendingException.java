package com.adria.notification.exceptions;

public class EmailSendingException extends RuntimeException{

    public EmailSendingException(String message, Throwable cause) {
        super(message, cause);
    }
}