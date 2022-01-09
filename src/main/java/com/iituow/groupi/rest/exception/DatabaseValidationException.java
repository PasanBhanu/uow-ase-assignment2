package com.iituow.groupi.rest.exception;

import com.iituow.groupi.rest.response.validation.ValidationError;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

@Data
@NoArgsConstructor
public class DatabaseValidationException extends RuntimeException {
    private Integer status = 400;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private String message = "Database validation failed";
    private ArrayList<ValidationError> validationErrors = null;

    public DatabaseValidationException(Integer status, HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.status = status;
        this.message = message;
    }

    public DatabaseValidationException(Integer status, HttpStatus httpStatus, String message, ArrayList<ValidationError> validationErrors) {
        this.httpStatus = httpStatus;
        this.status = status;
        this.message = message;
        this.validationErrors = validationErrors;
    }
}
