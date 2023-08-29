package com.userapi2.userappbackendrest.filter;

import com.userapi2.userappbackendrest.model.Person;
import com.userapi2.userappbackendrest.model.Token;
import com.userapi2.userappbackendrest.repository.PersonRepository;
import com.userapi2.userappbackendrest.service.CustomUserDetailsService;
import com.userapi2.userappbackendrest.utility.JWTUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JWTValidationFilter extends OncePerRequestFilter  {

    private JWTUtil jwtUtil=new JWTUtil();
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header=request.getHeader("Authorization");
        if(header!=null && header.startsWith("Bearer ")){
                String token=header.substring(7);
                System.out.println("Token : "+token);
                Token token1=new Token();
                token1.setToken(token.trim());
                String userName=jwtUtil.extractUserName(token1);
                System.out.println("User Name : "+userName);
            /*Authentication auth=new UsernamePasswordAuthenticationToken(userName,null,new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(auth);*/
                if(userName!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                    UserDetails details=customUserDetailsService.loadUserByUsername(userName);
                    if(jwtUtil.validateToken(token,details)){
                        Authentication auth=new UsernamePasswordAuthenticationToken(userName,null,details.getAuthorities());
                        System.out.println("Authentcated : "+auth.isAuthenticated());
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
        }
        filterChain.doFilter(request,response);
        System.out.println("Auhenticated Successfully!!!");
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest req){
        return req.getServletPath().equals("/api/token");

    }


}
