package com.samuelmaia1.github.marca_ai_api.marca_ai.mappers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseUserDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces.Mapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Consultation;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, RequestUserDto, ResponseUserDto> {
    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public ResponseUserDto toDto(User user) {
        ResponseUserDto dto = new ResponseUserDto(user);

        for (Consultation consultation : user.getConsultations()) {
            dto
                .getConsultations()
                .add(consultationMapper.toDto(consultation));
        }

        return dto;
    }

    @Override
    public User toEntity(RequestUserDto dto) {
        return new User(dto);
    }
}
