package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.Data;

@Data
public class SaleItemRequestDTO {
    private Long productId;
    private Integer quantity;
}
