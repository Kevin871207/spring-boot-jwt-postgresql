package com.kevin.spring.security.postgresql.service;

import com.kevin.spring.security.postgresql.payload.response.BorrowingRecordRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BorrowingRecordService {

    List<BorrowingRecordRes> getRetunTimeNullborrowingRecordRes(Long inventoryId, Long userId);
}
