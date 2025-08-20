package com.samuelmaia1.github.marca_ai_api.marca_ai.services;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.exceptions.EntityNotFoundException;
import com.samuelmaia1.github.marca_ai_api.marca_ai.mappers.DoctorMapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Doctor;
import com.samuelmaia1.github.marca_ai_api.marca_ai.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Autowired
    private DoctorMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseDoctorDto create(RequestDoctorDto data) {
        Doctor doctor = mapper.toEntity(data);
        doctor.setPassword(passwordEncoder.encode(data.getPassword()));
        return mapper.toDto(repository.save(doctor));
    }

    public ResponseDoctorDto getById(UUID id) {
        return mapper
                .toDto(repository
                        .findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Doutor não encontrado com este id"))
                );
    }

}
