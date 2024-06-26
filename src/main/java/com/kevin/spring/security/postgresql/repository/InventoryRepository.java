package com.kevin.spring.security.postgresql.repository;

import com.kevin.spring.security.postgresql.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findByIsbn(String isbn);
}
