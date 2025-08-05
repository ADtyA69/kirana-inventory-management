package com.Springboot.Kirana_Inventory_Management.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.Entity.Product;
import com.Springboot.Kirana_Inventory_Management.Mapper.ProductMapper;
import com.Springboot.Kirana_Inventory_Management.Repo.ProductRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	
		@Autowired
	    private ProductRepo productRepository;

	    @Override
	    public ProductDTO createProduct(ProductDTO productDTO) {
	        Product product = ProductMapper.toEntity(productDTO);
	        return ProductMapper.toDTO(productRepository.save(product));
	    }

	    @Override
	    public ProductDTO getProductById(int id) {
	        Product product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
	        return ProductMapper.toDTO(product);
	    }

	    @Override
	    public List<ProductDTO> getAllProducts() {
	        return productRepository.findAll()
	                .stream()
	                .map(ProductMapper::toDTO)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
	    	Product existingProduct = productRepository.findById(id)
	    	        .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

	        if (!productRepository.existsById(id)) {
	            throw new RuntimeException("Product not found with id: " + id);
	        }
	        Product product = ProductMapper.toEntity(productDTO);
	        product.setId(id); // make sure ID is preserved
	        return ProductMapper.toDTO(productRepository.save(product));
	    }

	    @Override
	    public void deleteProduct(int id) {
	        productRepository.deleteById(id);
	    }
}
