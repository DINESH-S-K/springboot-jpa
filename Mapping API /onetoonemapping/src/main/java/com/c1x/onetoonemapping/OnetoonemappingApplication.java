package com.c1x.onetoonemapping;

import com.c1x.onetoonemapping.repository.UserProfileRepository;
import com.c1x.onetoonemapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnetoonemappingApplication {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnetoonemappingApplication.class, args);
    }
}

