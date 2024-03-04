package com.sparta.lv2.repository;

import com.sparta.lv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserId(Long userId);
}
