package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.Speciality;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Agreement;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Doctor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResponseDoctorDto {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String description;
    private String cpf;
    private String crm;
    private Speciality speciality;

    private List<ResponseRecurringAvailabilityDto> recurringAvailabilities = new ArrayList<>();
    private List<ResponseAvailabilityExceptionDto> exceptionsAvailabilities = new ArrayList<>();
    private List<Agreement> agreements = new ArrayList<>();
    private List<ResponseConsultationDto> consultations = new ArrayList<>();

    public ResponseDoctorDto(Doctor doctor) {
        this.id = doctor.getId();
        this.name = doctor.getName();
        this.lastName = doctor.getLastName();
        this.cpf = doctor.getCpf();
        this.crm = doctor.getCrm();
        this.email = doctor.getEmail();
        this.speciality = doctor.getSpeciality();
        this.birthDay = doctor.getBirthDay();
        this.description = doctor.getDescription();

        this.agreements = doctor.getAgreements();
    }
}
