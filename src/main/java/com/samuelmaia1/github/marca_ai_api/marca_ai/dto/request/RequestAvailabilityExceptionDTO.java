package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.AvailabilityExceptionType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class RequestAvailabilityExceptionDTO {
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private AvailabilityExceptionType type;

}
