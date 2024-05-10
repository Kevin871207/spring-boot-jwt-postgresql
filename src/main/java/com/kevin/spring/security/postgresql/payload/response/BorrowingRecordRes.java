package com.kevin.spring.security.postgresql.payload.response;

import lombok.Data;

import java.util.Date;

@Data
public class BorrowingRecordRes {

    private Long userId;

    private Long inventoryId;

    private Date borrowingTime;

    private Date returnTime;
}
