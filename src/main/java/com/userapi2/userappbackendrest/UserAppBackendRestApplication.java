package com.userapi2.userappbackendrest;

import com.userapi2.userappbackendrest.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserAppBackendRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserAppBackendRestApplication.class, args);

	}

}
