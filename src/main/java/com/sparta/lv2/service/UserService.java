package com.sparta.lv2.service;

import com.sparta.lv2.dto.UserRequestDto;
import com.sparta.lv2.dto.UserResponseDto;
import com.sparta.lv2.entity.User;
import com.sparta.lv2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto registerUser(UserRequestDto requestDto) {
        User user = new User(requestDto);
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser);
    }
}
