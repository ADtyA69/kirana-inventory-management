package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {
    private int saleId;
    private LocalDateTime saleDate;
    private double totalAmount;
    private List<SaleItemResponseDTO> items;
}
