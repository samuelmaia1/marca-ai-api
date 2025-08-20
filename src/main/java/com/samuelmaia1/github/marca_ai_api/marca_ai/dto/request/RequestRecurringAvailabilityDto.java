package com.samuelmaia1.github.marca_ai_api.marca_ai.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class RequestRecurringAvailabilityDto {
    private DayOfWeek dayOfWeek;
    private LocalTime start;
    private LocalTime end;
}
