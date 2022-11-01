package com.c1x.onetomanymapping;

import com.c1x.onetomanymapping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnetomanymappingApplication {

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnetomanymappingApplication.class, args);
    }
}