package com.userapi2.userappbackendrest.exception;

import com.userapi2.userappbackendrest.model.FailureResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.SignatureException;

@RestControllerAdvice
public class GlobalExceptionalHandler {
    @ExceptionHandler(UsernameExistsException.class)
    public FailureResponse UsernameExistsExceptionHandler(UsernameExistsException ex){
        FailureResponse failureResponse=new FailureResponse("Error","USERNAME_EXITS", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(EmailExistsException.class)
    public FailureResponse EmailExisttsExceptionHandler(EmailExistsException ex){
        FailureResponse failureResponse=new FailureResponse("Error","EMAIL_EXISTS", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(InvalidAgeException.class)
    public FailureResponse InvalidAgeExceptionHandler(InvalidAgeException ex){
        FailureResponse failureResponse=new FailureResponse("Error","INVALID_AGE", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(InvalidPasswordException.class)
    public FailureResponse InvalidPasswordExceptionHandler(InvalidPasswordException ex){
        FailureResponse failureResponse=new FailureResponse("Error","INVALID_PASSWOD", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public FailureResponse MethodAgrumentsHandler(MethodArgumentNotValidException ex){
        FailureResponse failureResponse=new FailureResponse("Error","INVALID_REQUEST", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(BadCredentialsException.class)
    public FailureResponse BadCredintailsExceptionHandler(BadCredentialsException ex){
        FailureResponse failureResponse=new FailureResponse("Error","INVALID_CREDINTAILS", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(KeyExistsException.class)
    public  FailureResponse KeyExistsExceptionHandler(KeyExistsException ex){
        FailureResponse failureResponse=new FailureResponse("Error","KEY_EXISTS", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(KeyNotFoundException.class)
    public FailureResponse KeyNotFoundExceptionHandler(KeyNotFoundException ex){
        FailureResponse failureResponse=new FailureResponse("Error","KEY_NOT_FOUND", ex.getMessage());
        return failureResponse;
    }
    @ExceptionHandler(SignatureException.class)
    public FailureResponse signatureExceptionHandler(SignatureException ex){
        FailureResponse failureResponse=new FailureResponse("Error","INVALID_KEY", ex.getMessage());
        return failureResponse;
    }
}
