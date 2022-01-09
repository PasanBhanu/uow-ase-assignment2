package com.iituow.groupi.rest.response.validation;

import com.iituow.groupi.rest.response.base.ErrorResponse;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ValidationErrorResponse extends ErrorResponse {
    private ArrayList<ValidationError> validationErrors;

    public ValidationErrorResponse(Integer status, String message, ArrayList<ValidationError> validationErrors) {
        this.setStatus(status);
        this.setMessage(message);
        this.validationErrors = validationErrors;
    }
}
