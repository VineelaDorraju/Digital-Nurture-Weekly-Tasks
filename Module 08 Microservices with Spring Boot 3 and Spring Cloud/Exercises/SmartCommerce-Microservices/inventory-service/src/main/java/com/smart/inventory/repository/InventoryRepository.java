package com.smart.inventory.repository;

import com.smart.inventory.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, String> {

    List<Inventory> findByAvailableQuantityGreaterThan(int quantity);

    boolean existsByProductId(String productId);
}