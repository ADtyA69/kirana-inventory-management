package com.Springboot.Kirana_Inventory_Management.Mapper;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.Entity.Product;

public class ProductMapper {

	
	 public static ProductDTO toDTO(Product product) {
	        return ProductDTO.builder()
	                .id(product.getId())
	                .name(product.getName())
	                .description(product.getDescription())
	                .category(product.getCategory())
	                .unitPrice(product.getUnitPrice())
	                .expiryDate(product.getExpiryDate())
	                .stock(product.getStock())
	                .build();
	    }

	    public static Product toEntity(ProductDTO dto) {
	        return Product.builder()
	                .id(dto.getId())
	                .name(dto.getName())
	                .description(dto.getDescription())
	                .category(dto.getCategory())
	                .unitPrice(dto.getUnitPrice())
	                .expiryDate(dto.getExpiryDate())
	                .stock(dto.getStock())
	                .build();
	    }
}
