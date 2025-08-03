package com.Springboot.Kirana_Inventory_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Springboot.Kirana_Inventory_Management.Entity.SaleItem;

@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {
}