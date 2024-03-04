package com.sparta.lv2.controller;

import com.sparta.lv2.dto.UserRequestDto;
import com.sparta.lv2.dto.UserResponseDto;
import com.sparta.lv2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user-regist")
    public UserResponseDto registerUser(@RequestBody UserRequestDto requestDto){
        return userService.registerUser(requestDto);
    }
}
