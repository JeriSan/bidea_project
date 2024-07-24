package com.backend.controller;

import com.backend.entity.BookRequest;
import com.backend.entity.BookResponse;
import com.backend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bidea")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookResponse> save (@RequestBody BookRequest bookRequest) {
        bookingService.save(bookRequest);
        BookResponse response = new BookResponse();
        response.setCode(200);
        response.setMessage("Book Accepted");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
