package com.Springboot.Kirana_Inventory_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.Service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable int id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
}
