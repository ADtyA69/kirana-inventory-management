package com.Springboot.Kirana_Inventory_Management.DTO;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleResponseDTO {
    private int id;
    private LocalDateTime saleDate;
    private double totalAmount;
    private List<SaleItemResponseDTO> items;
}
