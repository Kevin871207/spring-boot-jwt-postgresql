package com.kevin.spring.security.postgresql.payload.response;

import lombok.Data;

@Data
public class BookRes {

    private String isbn;

    private String name;

    private String author;

    private String introduction;
}
