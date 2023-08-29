package com.userapi2.userappbackendrest.service;

import com.userapi2.userappbackendrest.model.Person;
import com.userapi2.userappbackendrest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PersonRepository personRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person=personRepository.findByusername(username);
        UserDetails userDetails=new User(person.getUsername(),person.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
