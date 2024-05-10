package com.kevin.spring.security.postgresql.service.impl;


import com.kevin.spring.security.postgresql.models.BorrowingRecord;
import com.kevin.spring.security.postgresql.payload.response.BorrowingRecordRes;
import com.kevin.spring.security.postgresql.repository.BorrowingRecordRepository;
import com.kevin.spring.security.postgresql.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Autowired
    BorrowingRecordRepository borrowingRecordRepository;


    @Override
    public List<BorrowingRecordRes> getRetunTimeNullborrowingRecordRes(Long inventoryId, Long userId) {
        List<BorrowingRecord> borrowingRecords = borrowingRecordRepository.findByBorrowingRecordIdUserIdAndBorrowingRecordIdInventoryId(userId, inventoryId);

        List<BorrowingRecordRes> borrowingRecordResList = new LinkedList<>();
        if (borrowingRecords.size() == 0) {
            return Collections.emptyList();
        }
        for (BorrowingRecord borrowingRecord : borrowingRecords) {
            if (borrowingRecord.getReturnTime() == null) {
                BorrowingRecordRes borrowingRecordRes = new BorrowingRecordRes();
                borrowingRecordRes.setUserId(borrowingRecord.getBorrowingRecordId().getUserId());
                borrowingRecordRes.setInventoryId(borrowingRecord.getBorrowingRecordId().getUserId());
                borrowingRecordRes.setBorrowingTime(borrowingRecord.getBorrowingTime());
                borrowingRecordResList.add(borrowingRecordRes);
            }
        }
        return borrowingRecordResList;
    }
}
