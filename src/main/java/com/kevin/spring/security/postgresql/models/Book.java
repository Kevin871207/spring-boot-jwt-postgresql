package com.kevin.spring.security.postgresql.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
public class Book {

    @Id()
    private String isbn;

    private String name;

    private String author;

    private String introduction;

    public Book(String name, String author, String introduction) {
        this.isbn = generateRandomISBN();
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }

    public Book(String isbn, String name, String author, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }

    public static String generateRandomISBN() {
        // 生成前12位隨機數字
        Random random = new Random();
        StringBuilder isbnBuilder = new StringBuilder("978"); // 前三位國家或地區代碼
        for (int i = 0; i < 9; i++) {
            isbnBuilder.append(random.nextInt(10)); // 生成隨機數字
        }

        // 計算校驗碼
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Integer.parseInt(isbnBuilder.substring(i, i + 1));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int checksum = (10 - (sum % 10)) % 10;

        // 附加校驗碼
        isbnBuilder.append(checksum);

        return isbnBuilder.toString();
    }
}
