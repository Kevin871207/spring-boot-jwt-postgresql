package com.kevin.spring.security.postgresql.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class BorrowingRecordId implements Serializable {

    private long userId;

    private long inventoryId;

    public BorrowingRecordId(long userId, long inventoryId) {
        this.userId = userId;
        this.inventoryId = inventoryId;
    }
}
