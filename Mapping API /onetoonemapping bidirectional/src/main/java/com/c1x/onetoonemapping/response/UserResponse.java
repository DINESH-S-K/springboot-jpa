package com.c1x.onetoonemapping.response;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserResponse {

    private long id;
    private String name;
    private String email;

    private UserProfileResponse userProfileResponse;
}
