package com.iituow.groupi.rest.response.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse extends BaseResponse {
    private List<String> errors = null;

    public ErrorResponse(Integer status, String message, List<String> errors) {
        this.setStatus(status);
        this.setMessage(message);
        this.errors = errors;
    }

    public ErrorResponse(Integer status, String message) {
        this.setStatus(status);
        this.setMessage(message);
    }
}
