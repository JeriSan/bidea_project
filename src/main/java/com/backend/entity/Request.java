package com.backend.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request {
    private String userId;
    private String houseId;
    private String discountCode;
}
