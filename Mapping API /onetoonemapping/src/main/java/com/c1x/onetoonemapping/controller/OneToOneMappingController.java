package com.c1x.onetoonemapping.controller;


import com.c1x.onetoonemapping.entity.User;
import com.c1x.onetoonemapping.entity.UserProfile;
import com.c1x.onetoonemapping.repository.UserProfileRepository;
import com.c1x.onetoonemapping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/onetoone")
public class OneToOneMappingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @PostMapping("addUser")
    public User addUser(@RequestBody User user) {

        userRepository.save(user);
        return user;
    }

    @PostMapping("addUserProfile")
    public UserProfile addUserProfile(@RequestBody UserProfile userProfile) {
        userProfileRepository.save(userProfile);
        return userProfile;
    }

    @GetMapping("getUser")
    public User getUser(@RequestParam long id) {
        User user = userRepository.findById(id).orElseThrow(null);
        return user;
    }

    @PutMapping("update/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User user) {
        User getUser = userRepository.findById(id).orElseThrow(null);
        getUser.setName(user.getName());
        getUser.setEmail(user.getEmail());
//        getUser.setUserProfile(user.getUserProfile());
        userRepository.save(getUser);
        return getUser;
    }

    @DeleteMapping("delete/user/{id}")
    public User deleteUserById(@PathVariable long id) {
        User getUser = userRepository.findById(id).orElseThrow(null);
        userRepository.deleteById(id);
        return getUser;
    }
}



