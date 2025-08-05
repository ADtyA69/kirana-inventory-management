package com.Springboot.Kirana_Inventory_Management.Repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Springboot.Kirana_Inventory_Management.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	@Query("SELECT p FROM Product p WHERE p.expiryDate BETWEEN CURRENT_DATE AND :futureDate")
	List<Product> findExpiringSoon(@Param("futureDate") Date futureDate);

	@Query("SELECT p FROM Product p WHERE p.expiryDate < CURRENT_DATE")
	List<Product> findExpiredProducts();
}
