package com.sparta.lv2.dto;

import com.sparta.lv2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDto {
    private Long userId;
    private String name;
    private String gender;
    private String address;
    private String phoneNum;
    private String birthNum;

    public UserResponseDto(User user) {
        this.userId = user.getUserId();
        this.name = user.getName();
        this.gender = user.getGender();
        this.address = user.getAddress();
        this.birthNum = user.getBirthNum();
        this.phoneNum = user.getPhoneNum();
    }

}