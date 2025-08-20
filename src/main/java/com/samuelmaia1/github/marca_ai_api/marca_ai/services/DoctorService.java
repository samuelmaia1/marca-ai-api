package com.samuelmaia1.github.marca_ai_api.marca_ai.services;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public ResponseDoctorDto create(RequestDoctorDto data) {
        return null;
    }

}
