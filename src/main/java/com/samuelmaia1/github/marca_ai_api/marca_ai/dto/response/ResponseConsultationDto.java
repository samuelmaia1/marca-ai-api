package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.Speciality;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class ResponseConsultationDto {
    private UUID id;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private DoctorSummary doctor;

    @Data
    @NoArgsConstructor
    public static class DoctorSummary {
        private UUID id;
        private String name;
        private Speciality speciality;
    }
}
