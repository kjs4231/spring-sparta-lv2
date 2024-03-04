package com.sparta.lv2.dto;

import com.sparta.lv2.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    private String name = "";;
    private String gender = "";;
    private String address = "";;
    private String phoneNum = "";;
    private String birthNum = "";;

}
