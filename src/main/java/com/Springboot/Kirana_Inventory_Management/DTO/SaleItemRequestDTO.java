package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleItemRequestDTO {
    private int productId;
    private int quantity;
}
