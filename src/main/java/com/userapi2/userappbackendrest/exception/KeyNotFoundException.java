package com.userapi2.userappbackendrest.exception;

public class KeyNotFoundException extends RuntimeException{
    public KeyNotFoundException(String msg){
        super(msg);
    }
}
