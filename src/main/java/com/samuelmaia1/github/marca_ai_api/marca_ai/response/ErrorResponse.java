package com.samuelmaia1.github.marca_ai_api.marca_ai.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class ErrorResponse {
    private String message;
    private Integer status;
    private String error;
    private LocalDateTime time;

    public ErrorResponse(String message, Integer status, String error, LocalDateTime time) {
        this.message = message;
        this.status = status;
        this.error = error;
        this.time = time;
    }
}
