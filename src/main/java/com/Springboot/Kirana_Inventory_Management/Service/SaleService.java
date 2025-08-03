package com.Springboot.Kirana_Inventory_Management.Service;

import java.util.List;

import com.Springboot.Kirana_Inventory_Management.DTO.SaleRequestDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleResponseDTO;

public interface SaleService {
    SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO);
    SaleResponseDTO getSaleById(int id);
    List<SaleResponseDTO> getAllSales();
}
