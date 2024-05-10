package com.kevin.spring.security.postgresql.service.impl;


import com.kevin.spring.security.postgresql.models.BookStatus;
import com.kevin.spring.security.postgresql.models.BorrowingRecord;
import com.kevin.spring.security.postgresql.models.BorrowingRecordId;
import com.kevin.spring.security.postgresql.payload.response.BookRes;
import com.kevin.spring.security.postgresql.repository.BookRepository;
import com.kevin.spring.security.postgresql.repository.BorrowingRecordRepository;
import com.kevin.spring.security.postgresql.repository.InventoryRepository;
import com.kevin.spring.security.postgresql.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public BookRes getbookRes(String isbn) {
        if (bookRepository.findByIsbn(isbn).isPresent()) {
            var book = bookRepository.findByIsbn(isbn).get();
            BookRes bookRes = new BookRes();
            bookRes.setIsbn(book.getIsbn());
            bookRes.setName(book.getName());
            bookRes.setAuthor(book.getAuthor());
            bookRes.setIntroduction(book.getIntroduction());
            return bookRes;
        }
        return null;
    }

    @Override
    @Transactional
    public void borrowBook(String isbn, Long userId) {
        if (inventoryRepository.findByIsbn(isbn).isPresent()) {
            var inventory = inventoryRepository.findByIsbn(isbn).get();
            inventory.setStatus(BookStatus.BORROWED);
            List<BorrowingRecord> borrowingRecordList = borrowingRecordRepository.findByBorrowingRecordIdUserIdAndBorrowingRecordIdInventoryId(userId, inventory.getInventoryId());
            if (borrowingRecordList.isEmpty()) {
                BorrowingRecordId borrowingRecordId = new BorrowingRecordId(userId, inventory.getInventoryId());
                borrowingRecordRepository.save(new BorrowingRecord(borrowingRecordId, new Date(), null));
                inventoryRepository.save(inventory);
            } else {
                BorrowingRecord borrowingRecord = borrowingRecordList.get(0);
                borrowingRecord.setBorrowingTime(new Date());
                borrowingRecord.setReturnTime(null);
                borrowingRecordRepository.save(borrowingRecord);
                inventoryRepository.save(inventory);
            }

        }
    }

    @Override
    @Transactional
    public void returnBook(String isbn, Long userId) {
        if (inventoryRepository.findByIsbn(isbn).isPresent()) {
            var inventory = inventoryRepository.findByIsbn(isbn).get();
            inventory.setStatus(BookStatus.AVAILABLE);
            BorrowingRecordId borrowingRecordId = new BorrowingRecordId(userId, inventory.getInventoryId());
            List<BorrowingRecord> borrowingRecordList = borrowingRecordRepository.findByBorrowingRecordIdUserIdAndBorrowingRecordIdInventoryId(userId, inventory.getInventoryId());
            if (!borrowingRecordList.isEmpty()) {
                BorrowingRecord borrowingRecord = borrowingRecordList.get(0);
                borrowingRecord.setReturnTime(new Date());
                borrowingRecordRepository.save(borrowingRecord);
                inventoryRepository.save(inventory);
            }

        }
    }
}
