package com.Springboot.Kirana_Inventory_Management.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailySalesReportDTO {
    private String date;
    private double totalSales;
    private int totalOrders;
    private int totalItemsSold;
}
