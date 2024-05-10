package com.kevin.spring.security.postgresql.service;

import com.kevin.spring.security.postgresql.payload.response.InventoryRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<InventoryRes> getInventory();
}
