package com.userapi2.userappbackendrest.exception;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String msg){
        super(msg);
    }
}
