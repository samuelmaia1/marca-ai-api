package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.response;

import com.samuelmaia1.github.marca_ai_api.marca_ai.models.RecurringAvailability;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class ResponseRecurringAvailabilityDto {
    private DayOfWeek dayOfWeek;
    private LocalTime start;
    private LocalTime end;

    public ResponseRecurringAvailabilityDto(RecurringAvailability availability) {
        this.dayOfWeek = availability.getDayOfWeek();
        this.start = availability.getStart();
        this.end = availability.getEnd();
    }
}
