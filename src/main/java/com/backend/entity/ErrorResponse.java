package com.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private String statusCode;

    private String error;

    private String message;

}
