package com.Springboot.Kirana_Inventory_Management.DTO;

import java.util.List;

import lombok.Data;

@Data
public class SaleRequestDTO {
    private List<SaleItemRequestDTO> items;
}

