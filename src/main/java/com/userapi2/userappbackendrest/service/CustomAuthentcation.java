package com.userapi2.userappbackendrest.service;

import com.userapi2.userappbackendrest.model.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthentcation {
    @Autowired
    private AuthenticationManager authenticationManager;
    public void authentication(Auth auth){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(),auth.getPassword()));
    }
}
