package com.samuelmaia1.github.marca_ai_api.marca_ai.services;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.mappers.UserMapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.User;
import com.samuelmaia1.github.marca_ai_api.marca_ai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper mapper;

    public ResponseUserDto create(RequestUserDto data) {
        User user = mapper.toEntity(data);
        user.setPassword(passwordEncoder.encode(data.getPassword()));

        return mapper.toDto(repository.save(user));
    }
}
