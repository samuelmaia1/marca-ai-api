package com.samuelmaia1.github.marca_ai_api.marca_ai.mappers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestAvailabilityExceptionDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestRecurringAvailabilityDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseAvailabilityExceptionDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response.ResponseRecurringAvailabilityDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces.Mapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.*;
import com.samuelmaia1.github.marca_ai_api.marca_ai.repositories.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorMapper implements Mapper<Doctor, RequestDoctorDto, ResponseDoctorDto> {

    @Autowired
    private AgreementRepository agreementRepository;

    @Autowired
    private ConsultationMapper consultationMapper;

    @Override
    public ResponseDoctorDto toDto(Doctor doctor) {
        ResponseDoctorDto dto = new ResponseDoctorDto(doctor);

        for (Consultation consultation : doctor.getConsultations()) {
            dto.getConsultations().add(consultationMapper.toDto(consultation));
        }

        for (RecurringAvailability recurringAvailability : doctor.getRecurringAvailabilities()) {
            dto
                .getRecurringAvailabilities()
                .add(new ResponseRecurringAvailabilityDto(recurringAvailability));
        }

        for (AvailabilityException availabilityException : doctor.getExceptionsAvailabilities()) {
            dto
                    .getExceptionsAvailabilities()
                    .add(new ResponseAvailabilityExceptionDto(availabilityException));
        }

        return dto;
    }

    @Override
    public Doctor toEntity(RequestDoctorDto dto) {
        Doctor doctor = new Doctor(dto);

        if (dto.getRecurringAvailabilities() != null) {
            for (RequestRecurringAvailabilityDto av : dto.getRecurringAvailabilities()) {
                RecurringAvailability entity = new RecurringAvailability();
                entity.setDayOfWeek(av.getDayOfWeek());
                entity.setStart(av.getStart());
                entity.setEnd(av.getEnd());
                entity.setDoctor(doctor);
                doctor.getRecurringAvailabilities().add(entity);
            }
        }

        if (dto.getExceptionsAvailabilities() != null) {
            for (RequestAvailabilityExceptionDto ex : dto.getExceptionsAvailabilities()) {
                AvailabilityException entity = new AvailabilityException();
                entity.setDate(ex.getDate());
                entity.setStart(ex.getStart());
                entity.setEnd(ex.getEnd());
                entity.setType(ex.getType());
                entity.setDoctor(doctor);
                doctor.getExceptionsAvailabilities().add(entity);
            }
        }

        if (dto.getAgreements() != null) {
            List<Agreement> agreements = agreementRepository.findAllById(dto.getAgreements());
            doctor.setAgreements(agreements);
        }

        return doctor;
    }
}
