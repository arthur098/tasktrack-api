package com.tasktrack_api.service;

import com.tasktrack_api.model.User;
import com.tasktrack_api.model.dto.UserRequest;
import com.tasktrack_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private static final String ROLE = "USER";

    @Autowired
    private UserRepository repository;

    public void createUser(UserRequest userRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(passwordEncoder.encode(userRequest.password()))
                .role(ROLE)
                .createdAt(LocalDateTime.now())
                .build();

        this.repository.save(user);
    }

    public UserDetails findUserByUsername(String username) {
        return this.repository.findByEmail(username);
    }
}
