package com.userapi2.userappbackendrest.controllers;

import com.userapi2.userappbackendrest.model.*;
import com.userapi2.userappbackendrest.repository.DataRepository;
import com.userapi2.userappbackendrest.service.CustomAuthentcation;
import com.userapi2.userappbackendrest.service.PersonService;
import com.userapi2.userappbackendrest.utility.JWTUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private CustomAuthentcation customAuthentcation;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping ("/register")
    public SuccessResponse register(@Valid @RequestBody Person person){
        return personService.doRegister(person);
    }
    @PostMapping("/token")
    public TokenResponse generateToken(@RequestBody Auth auth){
        customAuthentcation.authentication(auth);
        Token t=jwtUtil.generateToken(auth.getUserName());
        TokenResponse tokenResponse=new TokenResponse("Success","Token Generated Successfully!!",t);
        return tokenResponse;
    }
    @PostMapping("/data")
    public DataSuccessResponse storeData(@RequestBody DataClass dataClass){
            return personService.storeData(dataClass);
    }
    @GetMapping("/data/{key}")
    public DataSuccessResponse fetchData(@PathVariable String key){
        return personService.getData(key);
    }
    @PutMapping("/data/{key}")
    public DataSuccessResponse updateData(@PathVariable String key,@RequestBody UpdateDataBody updateDataBody){
        return personService.updateData(key,updateDataBody.getValue());
    }
    @DeleteMapping("/data/{key}")
    public DataSuccessResponse deleteData(@PathVariable String key){
        return personService.deleteData(key);
    }
}

