package com.userapi2.userappbackendrest.exception;

public class KeyExistsException extends RuntimeException{
    public KeyExistsException(String msg){
        super(msg);
    }
}
