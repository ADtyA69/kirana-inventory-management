package com.Springboot.Kirana_Inventory_Management.Service;

import java.util.List;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;

public interface ProductService {
	
	ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO getProductById(int id);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(int id, ProductDTO productDTO);
    void deleteProduct(int id);

}
