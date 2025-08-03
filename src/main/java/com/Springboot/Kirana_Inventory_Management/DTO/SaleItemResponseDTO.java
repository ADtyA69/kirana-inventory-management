package com.Springboot.Kirana_Inventory_Management.DTO;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class SaleItemResponseDTO {
    private Long productId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;
}
