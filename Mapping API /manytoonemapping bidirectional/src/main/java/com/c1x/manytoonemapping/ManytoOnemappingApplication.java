package com.c1x.manytoonemapping;

import com.c1x.manytoonemapping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManytoOnemappingApplication {

    @Autowired
    private CartRepository cartRepository;

    public static void main(String[] args) {
        SpringApplication.run(ManytoOnemappingApplication.class, args);
    }
}