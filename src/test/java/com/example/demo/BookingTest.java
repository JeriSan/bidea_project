package com.example.demo;

import com.backend.ProyectoApp;
import com.backend.entity.BookRequest;
import com.backend.repository.BookingRepository;
import com.backend.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = ProyectoApp.class)
public class BookingTest {
    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @Test
    public void addDataIntoRequest() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setId("14564081-1");
        bookRequest.setName("Fatima");
        bookRequest.setLastname("Martinez");
        bookRequest.setAge(33);
        bookRequest.setPhoneNumber("222911222");
        bookRequest.setStartDate("2024-07-21");
        bookRequest.setEndDate("2024-07-21");
        bookRequest.setHouseId("213212");
        bookRequest.setDiscountCode("D0511923");

        bookingService.save(bookRequest);
    }
}
