package com.iituow.groupi.rest.response.base;

import com.iituow.groupi.rest.exception.DatabaseValidationException;
import com.iituow.groupi.rest.exception.LogicViolationException;
import com.iituow.groupi.rest.exception.ServiceException;
import com.iituow.groupi.rest.response.validation.ValidationErrorResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler(DatabaseValidationException.class)
    protected <T extends ErrorResponse> ResponseEntity<T> handleDatabaseValidationException(DatabaseValidationException ex) {
        ValidationErrorResponse response = new ValidationErrorResponse(ex.getStatus(), ex.getMessage(), ex.getValidationErrors());
        return new ResponseEntity<>((T) response, ex.getHttpStatus());
    }

    @ExceptionHandler(LogicViolationException.class)
    protected <T extends ErrorResponse> ResponseEntity<T> handleLogicViolationException(LogicViolationException ex) {
        ErrorResponse response = new ErrorResponse(ex.getStatus(), ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>((T) response, ex.getHttpStatus());
    }

    @ExceptionHandler(ServiceException.class)
    protected <T extends ErrorResponse> ResponseEntity<T> handleServiceException(ServiceException ex) {
        ErrorResponse response = new ErrorResponse(ex.getStatus(), ex.getMessage(), ex.getErrors());
        return new ResponseEntity<>((T) response, ex.getHttpStatus());
    }
}
