package com.kevin.spring.security.postgresql.repository.dataloader;

import com.kevin.spring.security.postgresql.models.*;
import com.kevin.spring.security.postgresql.repository.BookRepository;
import com.kevin.spring.security.postgresql.repository.BorrowingRecordRepository;
import com.kevin.spring.security.postgresql.repository.InventoryRepository;
import com.kevin.spring.security.postgresql.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class BookDataLoader implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Load initial data into the database
        Book book1 = new Book("Book 1", "Author 1", "Description 1");
        Book book2 = new Book("Book 2", "Author 2", "Description 2");
        Book book3 = new Book("Book 3", "Author 3", "Description 3");
        Book book4 = new Book("Book 4", "Author 4", "Description 4");
        Date now = new Date();

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        Inventory inventory1 = new Inventory(book1.getIsbn(), now, BookStatus.BORROWED);
        Inventory inventory2 = new Inventory(book2.getIsbn(), now, BookStatus.BORROWED);
        Inventory inventory3 = new Inventory(book3.getIsbn(), now, BookStatus.AVAILABLE);
        Inventory inventory4 = new Inventory(book4.getIsbn(), now, BookStatus.AVAILABLE);
        inventoryRepository.save(inventory1);
        inventoryRepository.save(inventory2);
        inventoryRepository.save(inventory3);
        inventoryRepository.save(inventory4);

        borrowingRecordRepository.save(new BorrowingRecord(new BorrowingRecordId(1L, 1L), now, null));
        borrowingRecordRepository.save(new BorrowingRecord(new BorrowingRecordId(2L, 2L), now, null));

        userRepository.save(new User("0918321985",
                "$2a$10$cS286UfDZ2zz2zgHafkKIOy96wskTca.v4lQs2Id9JChMx/mKnioC",
                "kevin",
                "ss5170505@gmail.com",
                new Date(),
                new Date()));
    }
}