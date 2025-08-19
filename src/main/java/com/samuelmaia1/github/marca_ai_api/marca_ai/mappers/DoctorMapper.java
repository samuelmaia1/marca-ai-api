package com.samuelmaia1.github.marca_ai_api.marca_ai.mappers;

import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestAvailabilityExceptionDTO;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestDoctorDto;
import com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request.RequestRecurringAvailabilityDTO;
import com.samuelmaia1.github.marca_ai_api.marca_ai.interfaces.Mapper;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Agreement;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.AvailabilityException;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Doctor;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.RecurringAvailability;
import com.samuelmaia1.github.marca_ai_api.marca_ai.repositories.AgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DoctorMapper implements Mapper<Doctor, RequestDoctorDto> {

    @Autowired
    private AgreementRepository agreementRepository;

    @Override
    public RequestDoctorDto toDto(Doctor doctor) {
        return null;
    }

    @Override
    public Doctor toEntity(RequestDoctorDto dto) {
        Doctor doctor = new Doctor(dto);

        if (dto.getRecurringAvailabilities() != null) {
            for (RequestRecurringAvailabilityDTO av : dto.getRecurringAvailabilities()) {
                RecurringAvailability entity = new RecurringAvailability();
                entity.setDayOfWeek(av.getDayOfWeek());
                entity.setStart(av.getStart());
                entity.setEnd(av.getEnd());
                entity.setDoctor(doctor);
                doctor.getRecurringAvailabilities().add(entity);
            }
        }

        if (dto.getExceptionsAvailabilities() != null) {
            for (RequestAvailabilityExceptionDTO ex : dto.getExceptionsAvailabilities()) {
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
