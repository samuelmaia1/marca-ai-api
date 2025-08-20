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

        ResponseConsultationDto.DoctorSummary doctorSummary = new ResponseConsultationDto.DoctorSummary();
        doctorSummary.setId(consultation.getDoctor().getId());
        doctorSummary.setName(consultation.getDoctor().getName());
        doctorSummary.setSpeciality(consultation.getDoctor().getSpeciality());
        dto.setDoctor(doctorSummary);

        ResponseConsultationDto.PatientSummary patientSummary = new ResponseConsultationDto.PatientSummary();
        patientSummary.setId(consultation.getPatient().getId());
        patientSummary.setName(consultation.getPatient().getName());
        patientSummary.setLastName(consultation.getPatient().getLastName());
        dto.setPatient(patientSummary);

        return dto;
    }

    @Override
    public Consultation toEntity(RequestConsultationDto dto) {
        return null;
    }
}
