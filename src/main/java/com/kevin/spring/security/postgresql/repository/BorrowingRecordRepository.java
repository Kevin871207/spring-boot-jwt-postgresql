package com.kevin.spring.security.postgresql.repository;

import com.kevin.spring.security.postgresql.models.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    List<BorrowingRecord> findByBorrowingRecordIdUserIdAndBorrowingRecordIdInventoryId(Long userId, Long inventoryId);

}
