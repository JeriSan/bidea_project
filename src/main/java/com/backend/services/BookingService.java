package com.backend.services;

import com.backend.entity.BookRequest;
import com.backend.entity.Request;
import com.backend.error.MaxRetryException;
import com.backend.repository.BookingRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Slf4j
@Service
@Validated
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    RestTemplate restTemplate;

    @Transactional
    public void save(@Valid BookRequest bookRequest){
        log.info("Trying to save bookRequest");
        long currentTime = new Date().getTime();
        int i = 0;
        while(i < 3) {
            try {
                invocarApi(bookRequest);
                break;
            } catch (Exception e) {
                i++;
                if (i == 3) {
                    throw new MaxRetryException("The maximum number of retries reached the maximum number of attempts");
                }
                if (new Date().getTime() - currentTime > 5000) {
                    throw new MaxRetryException("The maximum retry time reached 5 seconds of waiting");
                }
            }
        }

        bookingRepository.save(bookRequest);
    }

    public void invocarApi(BookRequest bookRequest){
        log.info("Trying to use api");
        String url = "https://sbv2bumkomidlxwffpgbh4k6jm0ydskh.lambda-url.us-east-1.on.aws/";

        Request request = new Request();
        request.setUserId(bookRequest.getId());
        request.setHouseId(bookRequest.getHouseId());
        request.setDiscountCode(bookRequest.getDiscountCode());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Request> entity = new HttpEntity<>(request, headers);

        restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
    }
}
