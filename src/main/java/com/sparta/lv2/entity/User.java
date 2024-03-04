package com.sparta.lv2.entity;

import com.sparta.lv2.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "birthNum", nullable = false, unique = true, length = 100)
    private String birthNum = "";

    @Column(name = "phoneNum", nullable = false, unique = true, length = 100)
    private String phoneNum = "";

    @Column(name = "name", nullable = false, length = 100)
    private String name = "";;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender = "";;

    @Column(name = "address", nullable = false, length = 1000)
    private String address = "";;

    public User(UserRequestDto requestDto) {
        this.birthNum = requestDto.getBirthNum();
        this.phoneNum = requestDto.getPhoneNum();
        this.name = requestDto.getName();
        this.gender = requestDto.getGender();
        this.address = requestDto.getAddress();
    }

}
