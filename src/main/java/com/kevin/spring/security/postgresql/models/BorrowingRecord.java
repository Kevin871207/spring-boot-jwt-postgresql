package com.kevin.spring.security.postgresql.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "borrowing_record")
@Data
@NoArgsConstructor
public class BorrowingRecord {

    @EmbeddedId
    private BorrowingRecordId borrowingRecordId;

    private Date borrowingTime;

    private Date returnTime;

    public BorrowingRecord(BorrowingRecordId borrowingRecordId, Date borrowingTime, Date returnTime) {
        this.borrowingRecordId = borrowingRecordId;
        this.borrowingTime = borrowingTime;
        this.returnTime = returnTime;
    }
}
