package com.samuelmaia1.github.marca_ai_api.marca_ai.infra;

import com.samuelmaia1.github.marca_ai_api.marca_ai.exceptions.EntityNotFoundException;
import com.samuelmaia1.github.marca_ai_api.marca_ai.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
        ErrorResponse error = buildError(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }


    private ErrorResponse buildError(HttpStatus status, String message) {
        return new ErrorResponse(
            message,
            status.value(),
            status.getReasonPhrase(),
            LocalDateTime.now()
        );
    }
}
