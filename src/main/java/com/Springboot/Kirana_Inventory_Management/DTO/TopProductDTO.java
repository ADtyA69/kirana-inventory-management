package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopProductDTO {
    private String productName;
    private int totalUnitsSold;
}
