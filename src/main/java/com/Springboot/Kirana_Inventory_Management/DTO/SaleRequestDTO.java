package com.Springboot.Kirana_Inventory_Management.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleRequestDTO {
    private List<SaleItemRequestDTO> items;
}
