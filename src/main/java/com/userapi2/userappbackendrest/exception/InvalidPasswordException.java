package com.userapi2.userappbackendrest.exception;

public class InvalidPasswordException extends RuntimeException{
    public InvalidPasswordException(String msg){
        super(msg);
    }
}
