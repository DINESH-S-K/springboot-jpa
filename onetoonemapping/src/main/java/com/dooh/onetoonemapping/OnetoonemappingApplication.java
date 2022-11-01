package com.dooh.onetoonemapping;

import com.dooh.onetoonemapping.entity.*;
import com.dooh.onetoonemapping.repository.UserProfileRepository;
import com.dooh.onetoonemapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OnetoonemappingApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(OnetoonemappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //unidirectional
//        User user = new User();
//        user.setName("Dinesh");
//        user.setEmail("123@gmail.com");
//
//        UserProfile userProfile = new UserProfile();
//        userProfile.setPhoneNumber("7903051241");
//        userProfile.setAddress("okikiyam thorraipakkam");
//        userProfile.setBirthOfDate(LocalDate.of(2001, 05, 01));
//        userProfile.setGender(Gender.MALE);
//
//        user.setUserProfile(userProfile);
//
//        userRepository.save(user);

        //bidirectional

        User1 user1 = new User1();
        user1.setName("Gokul");
        user1.setEmail("gokul@gmail.com");

        UserProfile1 userProfile1 = new UserProfile1();
        userProfile1.setPhoneNumber("7903051241");
        userProfile1.setAddress("bangalore");
        userProfile1.setBirthOfDate(LocalDate.of(2002, 03, 04));
        userProfile1.setGender(Gender.MALE);

        user1.setUserProfile1(userProfile1);
        userProfile1.setUser1(user1);

        //CascadeTYpe.ALL .so anyone object stores another object automatically store
        userRepository.save(user1);
//        userProfileRepository.save(userProfile1);
    }
}
