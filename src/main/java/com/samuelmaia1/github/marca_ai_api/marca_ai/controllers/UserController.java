package com.samuelmaia1.github.marca_ai_api.marca_ai.controllers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseUserDto> createUser(@RequestBody RequestUserDto data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(data));
    }
}
