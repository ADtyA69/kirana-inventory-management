package com.Springboot.Kirana_Inventory_Management.Service;

import java.util.List;
import com.Springboot.Kirana_Inventory_Management.DTO.*;

public interface ReportService {
    DailySalesReportDTO getDailySalesReport();
    List<DailySalesReportDTO> getMonthlySalesReport();
    List<TopProductDTO> getTopSellingProducts();
    InvoiceDTO generateInvoice(int saleId);
}
