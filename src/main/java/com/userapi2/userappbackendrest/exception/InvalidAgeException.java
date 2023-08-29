package com.userapi2.userappbackendrest.exception;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String msg){
        super(msg);
    }
}
