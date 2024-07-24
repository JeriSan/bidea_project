package com.backend.repository;

import com.backend.entity.BookRequest;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookRequest, String> {
}
