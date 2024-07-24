package com.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="book_request")
public class BookRequest {
    @Id
    @Size(min = 9, max = 10, message = "Longitud permitida para el id es de 9 a 10 caracteres")
    @Column(name = "id")
    private String id;

    @Size(min = 2, max = 50, message = "Longitud permitida para el nombre es de 2 a 10 caracteres")
    @Column(name = "name")
    private String name;

    @Size(min = 2, max = 50, message = "Longitud permitida para el apellido es de 2 a 10 caracteres")
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Size(min = 9, max = 20, message = "Longitud permitida para la phone number es de 9 a 20 caracteres")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Size(min = 6, max = 15, message = "Longitud permitida para el house id es de 6 a 15 caracteres")
    @Column(name = "house_id")
    private String houseId;

    @Size(min = 8, max = 8, message = "Longitud permitida para el house id es de 8 a 8 caracteres")
    @Column(name = "discount_code")
    private String discountCode;


}
