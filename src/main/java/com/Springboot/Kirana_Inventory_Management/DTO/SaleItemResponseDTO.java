package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemResponseDTO {
    private int productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
}
