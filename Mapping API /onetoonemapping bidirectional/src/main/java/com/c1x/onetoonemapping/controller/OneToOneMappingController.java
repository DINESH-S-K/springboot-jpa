package com.c1x.onetoonemapping.controller;


import com.c1x.onetoonemapping.entity.User;
import com.c1x.onetoonemapping.entity.UserProfile;
import com.c1x.onetoonemapping.repository.UserProfileRepository;
import com.c1x.onetoonemapping.repository.UserRepository;
import com.c1x.onetoonemapping.response.UserProfileResponse;
import com.c1x.onetoonemapping.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/onetoone")
public class OneToOneMappingController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserResponse userResponse;

    @Autowired
    private UserProfileResponse userProfileResponse;

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

    @GetMapping("getUser/{id}")
    public User getUserResponse(@PathVariable long id) {
        User user = userRepository.findById(id).orElseThrow(null);
//        UserResponse userResponse = new UserResponse();
//        userResponse.setName(user.getName());
//        userResponse.setEmail(user.getEmail());
//        userResponse.setId(user.getId());
//
//        UserProfileResponse userProfileResponse = new UserProfileResponse();
//        userProfileResponse.setId(user.getUserProfile().getId());
//        userProfileResponse.setAddress(user.getUserProfile().getAddress());
//        userProfileResponse.setPhoneNumber(user.getUserProfile().getPhoneNumber());
//        userProfileResponse.setGender(user.getUserProfile().getGender());
//        userProfileResponse.setBirthOfDate(user.getUserProfile().getBirthOfDate());
//
//        userResponse.setUserProfileResponse(userProfileResponse);
//
//        return userResponse ;
        return user;
    }

    @GetMapping("getUserProfile")
    public UserProfile getUserProfileResponse(@RequestParam long userProfile_id) {
        UserProfile userProfile = userProfileRepository.findById(userProfile_id).orElseThrow(null);
//        UserProfileResponse userProfileResponse = new UserProfileResponse();
//        userProfileResponse.setId(userProfile.getId());
//        userProfileResponse.setAddress(userProfile.getAddress());
//        userProfileResponse.setPhoneNumber(userProfile.getPhoneNumber());
//        userProfileResponse.setGender(userProfile.getGender());
//        userProfileResponse.setBirthOfDate(userProfile.getBirthOfDate());
        return userProfile;
    }

    @PutMapping("update/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User user) {
        User getUser = userRepository.findById(id).orElseThrow(null);
        getUser.setName(user.getName());
        getUser.setEmail(user.getEmail());

        getUser.getUserProfile().setPhoneNumber(user.getUserProfile().getPhoneNumber());
        getUser.getUserProfile().setAddress(user.getUserProfile().getAddress());
        getUser.getUserProfile().setGender(user.getUserProfile().getGender());
        getUser.getUserProfile().setBirthOfDate(user.getUserProfile().getBirthOfDate());


        userRepository.save(getUser);
////        return "successfully updated";
//        System.out.println(id);
//        System.out.println(user.getId());
//        System.out.println(getUser.getId());

        return getUser;
    }

    @PutMapping("update/userProfile/{id}")
    public UserProfile updateUserProfileById(@PathVariable long id, @RequestBody UserProfile userProfile) {
        UserProfile getUserProfile = userProfileRepository.findById(id).orElseThrow(null);
        getUserProfile.setPhoneNumber(userProfile.getPhoneNumber());
        getUserProfile.setAddress(userProfile.getAddress());
        getUserProfile.setGender(userProfile.getGender());
        getUserProfile.setBirthOfDate(userProfile.getBirthOfDate());

        userProfileRepository.save(getUserProfile);
//        return "successfully updated UserProfile";
        return getUserProfile;
    }

    @DeleteMapping("delete/user/{id}")
    public User deleteUserById(@PathVariable long id) {
        User getUser = userRepository.findById(id).orElseThrow(null);
        userRepository.deleteById(id);
        return getUser;
    }

    @DeleteMapping("delete/userProfile/{id}")
    public UserProfile deleteUserProfileById(@PathVariable long id) {
        UserProfile getUserProfile = userProfileRepository.findById(id).orElseThrow(null);
        userProfileRepository.deleteById(id);
        return getUserProfile;
    }
}



