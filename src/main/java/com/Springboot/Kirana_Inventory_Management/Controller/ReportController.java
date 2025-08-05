package com.Springboot.Kirana_Inventory_Management.Controller;

import com.Springboot.Kirana_Inventory_Management.DTO.*;
import com.Springboot.Kirana_Inventory_Management.Service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/daily")
    public ResponseEntity<DailySalesReportDTO> getDailyReport() {
        return ResponseEntity.ok(reportService.getDailySalesReport());
    }

    @GetMapping("/monthly")
    public ResponseEntity<List<DailySalesReportDTO>> getMonthlyReport() {
        return ResponseEntity.ok(reportService.getMonthlySalesReport());
    }

    @GetMapping("/top-products")
    public ResponseEntity<List<TopProductDTO>> getTopProducts() {
        return ResponseEntity.ok(reportService.getTopSellingProducts());
    }

    @GetMapping("/invoice/{saleId}")
    public ResponseEntity<InvoiceDTO> getInvoice(@PathVariable int saleId) {
        return ResponseEntity.ok(reportService.generateInvoice(saleId));
    }
}
