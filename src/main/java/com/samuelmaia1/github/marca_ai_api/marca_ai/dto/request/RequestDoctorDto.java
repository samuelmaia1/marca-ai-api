package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.Speciality;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestDoctorDto {
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String description;
    private String password;
    private String cpf;
    private String crm;
    private Speciality speciality;

    private List<RequestRecurringAvailabilityDto> recurringAvailabilities = new ArrayList<>();
    private List<RequestAvailabilityExceptionDto> exceptionsAvailabilities = new ArrayList<>();
    private List<UUID> agreements;
}
