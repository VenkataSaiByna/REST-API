package com.userapi2.userappbackendrest.exception;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String msg){
        super(msg);
    }
}
