package com.kevin.spring.security.postgresql.payload.response;

import com.kevin.spring.security.postgresql.models.BookStatus;
import lombok.Data;

import java.util.Date;

@Data
public class InventoryRes {

    private long inventoryId;

    private String ISBN;

    private Date storeTime;

    private BookStatus status;

    private String name;

    private String author;

    private String introduction;

}
