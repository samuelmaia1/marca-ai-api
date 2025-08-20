package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response;

import com.samuelmaia1.github.marca_ai_api.marca_ai.enums.AvailabilityExceptionType;
import com.samuelmaia1.github.marca_ai_api.marca_ai.models.AvailabilityException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ResponseAvailabilityExceptionDto {
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private AvailabilityExceptionType type;

    public ResponseAvailabilityExceptionDto(AvailabilityException exception) {
        this.date = exception.getDate();
        this.end = exception.getEnd();
        this.start = exception.getStart();
        this.type = exception.getType();
    }
}
