package com.backend.controller;

import com.backend.entity.ErrorResponse;
import com.backend.error.MaxRetryException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;


@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCustomNotFoundException(ConstraintViolationException ex) {
       ConstraintViolation cons = ex.getConstraintViolations().stream().findFirst().orElse(null);

       String detail = cons != null ? "required property: "+cons.getPropertyPath().toString() : "Validation error";
       ErrorResponse response = new ErrorResponse();
       response.setStatusCode("400");
       response.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
       response.setMessage(detail);
       return response;
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleHttpClientErrorException(HttpClientErrorException e) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode("409");
        response.setError(HttpStatus.CONFLICT.getReasonPhrase());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler(MaxRetryException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleMaxRetryException(MaxRetryException e) {
        ErrorResponse response = new ErrorResponse();
        response.setStatusCode("409");
        response.setError(HttpStatus.CONFLICT.getReasonPhrase());
        response.setMessage(e.getMessage());
        return response;
    }

}
