package com.kevin.spring.security.postgresql.controllers;

import com.kevin.spring.security.postgresql.payload.response.BookRes;
import com.kevin.spring.security.postgresql.service.BookService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/bookStatus")
    public ResponseEntity<BookRes> getBookStatus(@PathVariable("isbn") @NotBlank String isbn) {
        BookRes bookRes = bookService.getbookRes(isbn);

        return new ResponseEntity<>(bookRes, HttpStatus.OK);
    }

    @PatchMapping("/borrow/{isbn}/user/{userId}")
    public void borrowBook(@PathVariable("isbn") @NotBlank String isbn, @PathVariable("userId") @NotBlank Long userId) {
        bookService.borrowBook(isbn, userId);
    }

    @PatchMapping("/return/{isbn}/user/{userId}")
    public void returnBook(@PathVariable("isbn") @NotBlank String isbn, @PathVariable("userId") @NotBlank Long userId) {
        bookService.returnBook(isbn, userId);
    }

}
