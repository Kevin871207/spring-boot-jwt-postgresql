package com.kevin.spring.security.postgresql.service.impl;


import com.kevin.spring.security.postgresql.payload.response.BookRes;
import com.kevin.spring.security.postgresql.payload.response.InventoryRes;
import com.kevin.spring.security.postgresql.repository.InventoryRepository;
import com.kevin.spring.security.postgresql.service.BookService;
import com.kevin.spring.security.postgresql.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<InventoryRes> getInventory() {
        return inventoryRepository.findAll().stream().map(
                inventory -> {
                    InventoryRes inventoryRes = new InventoryRes();
                    inventoryRes.setInventoryId(inventory.getInventoryId());
                    inventoryRes.setISBN(inventory.getIsbn());
                    inventoryRes.setStoreTime(inventory.getStoreTime());
                    inventoryRes.setStatus(inventory.getStatus());
                    BookRes bookRes = bookService.getbookRes(inventory.getIsbn());
                    inventoryRes.setName(bookRes.getName());
                    inventoryRes.setAuthor(bookRes.getAuthor());
                    inventoryRes.setIntroduction(bookRes.getIntroduction());
                    return inventoryRes;
                }
        ).toList();
    }
}
