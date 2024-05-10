package com.kevin.spring.security.postgresql.service;

import com.kevin.spring.security.postgresql.payload.response.BookRes;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    BookRes getbookRes(String isbn);

    void borrowBook(String isbn, Long userId);

    void returnBook(String isbn, Long userId);
}
