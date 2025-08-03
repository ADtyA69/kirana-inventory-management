package com.Springboot.Kirana_Inventory_Management.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class SaleResponseDTO {
    private Long id;
    private LocalDate saleDate;
    private BigDecimal totalAmount;
    private List<SaleItemResponseDTO> items;
}
