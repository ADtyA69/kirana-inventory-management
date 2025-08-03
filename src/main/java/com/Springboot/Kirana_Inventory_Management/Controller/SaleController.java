package com.Springboot.Kirana_Inventory_Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Kirana_Inventory_Management.DTO.SaleRequestDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleResponseDTO;
import com.Springboot.Kirana_Inventory_Management.Service.SaleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleResponseDTO> createSale(@RequestBody SaleRequestDTO request) {
        return ResponseEntity.ok(saleService.createSale(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleResponseDTO> getSale(@PathVariable int id) {
        return ResponseEntity.ok(saleService.getSaleById(id));
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDTO>> getAllSales() {
        return ResponseEntity.ok(saleService.getAllSales());
    }
}

