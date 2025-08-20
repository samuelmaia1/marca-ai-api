package com.samuelmaia1.github.marca_ai_api.marca_ai.mappers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestConsultationDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseConsultationDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces.Mapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Consultation;
import org.springframework.stereotype.Component;

@Component
public class ConsultationMapper implements Mapper<Consultation, RequestConsultationDto, ResponseConsultationDto> {


    @Override
    public ResponseConsultationDto toDto(Consultation consultation) {
        ResponseConsultationDto dto = new ResponseConsultationDto();
        dto.setDate(consultation.getDate());
        dto.setId(consultation.getId());
        dto.setEnd(consultation.getEnd());
        dto.setStart(consultation.getStart());

        ResponseConsultationDto.DoctorSummary summary = new ResponseConsultationDto.DoctorSummary();
        summary.setId(consultation.getDoctor().getId());
        summary.setName(consultation.getDoctor().getName());
        summary.setSpeciality(consultation.getDoctor().getSpeciality());
        dto.setDoctor(summary);

        return dto;
    }

    @Override
    public Consultation toEntity(RequestConsultationDto dto) {
        return null;
    }
}
