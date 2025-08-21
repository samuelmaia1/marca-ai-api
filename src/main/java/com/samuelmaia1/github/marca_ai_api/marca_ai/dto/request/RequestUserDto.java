package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class RequestUserDto {
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDay;
    private String description;
    private String password;
    private String cpf;
}
