package com.samuelmaia1.github.marca_ai_api.marca_ai.controllers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseDoctorDto> createDoctor(@RequestBody RequestDoctorDto data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDoctorDto> getDoctorById(@PathVariable UUID id) {
        return ResponseEntity
                .ok(service.getById(id));
    }
}
