package com.Springboot.Kirana_Inventory_Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Springboot.Kirana_Inventory_Management.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
