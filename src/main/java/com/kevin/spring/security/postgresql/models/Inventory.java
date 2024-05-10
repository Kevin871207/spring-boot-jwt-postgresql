package com.kevin.spring.security.postgresql.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
public class Inventory {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long inventoryId;

    private String isbn;

    private Date storeTime;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private BookStatus status;

    public Inventory(String isbn, Date storeTime, BookStatus status) {
        this.isbn = isbn;
        this.storeTime = storeTime;
        this.status = status;
    }
}
