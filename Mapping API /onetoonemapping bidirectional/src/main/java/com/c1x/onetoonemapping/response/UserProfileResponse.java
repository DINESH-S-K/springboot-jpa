package com.c1x.onetoonemapping.response;

import com.c1x.onetoonemapping.entity.Gender;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class UserProfileResponse {

    private long id;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private LocalDate birthOfDate;

}
