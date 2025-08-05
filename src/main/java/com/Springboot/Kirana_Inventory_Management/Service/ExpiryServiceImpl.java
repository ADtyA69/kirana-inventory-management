	package com.Springboot.Kirana_Inventory_Management.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.Entity.Product;
import com.Springboot.Kirana_Inventory_Management.Mapper.ProductMapper;
import com.Springboot.Kirana_Inventory_Management.Repo.ProductRepo;

import lombok.RequiredArgsConstructor;

	@Service
	@RequiredArgsConstructor
	public class ExpiryServiceImpl implements ExpiryService {

	    private final ProductRepo productRepository;
	   


	    @Override
	    public List<ProductDTO> getExpiringSoon(int daysAhead) {
	        LocalDate futureDate = LocalDate.now().plusDays(daysAhead);
	        List<Product> products = productRepository.findExpiringSoon(java.sql.Date.valueOf(futureDate));
	        return products.stream()
	                       .map(ProductMapper::toDTO)  // Static call
	                       .collect(Collectors.toList());
	    }

	    @Override
	    public List<ProductDTO> getExpiredProducts() {
	        List<Product> products = productRepository.findExpiredProducts();
	        return products.stream()
	                       .map(ProductMapper::toDTO)  // Static call
	                       .collect(Collectors.toList());
	    }
	}
	
