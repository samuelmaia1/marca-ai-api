package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.Speciality;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Agreement;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.Doctor;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResponseUserDto {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String description;
    private String cpf;
    private String crm;
    private Speciality speciality;

    private List<ResponseConsultationDto> consultations = new ArrayList<>();

    public ResponseUserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.lastName = user.getLastName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.birthDay = user.getBirthDay();
        this.description = user.getDescription();
    }
}
