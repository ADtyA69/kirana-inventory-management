package com.Springboot.Kirana_Inventory_Management.Service;

import com.Springboot.Kirana_Inventory_Management.DTO.*;
import com.Springboot.Kirana_Inventory_Management.Entity.Sale;
import com.Springboot.Kirana_Inventory_Management.Entity.SaleItem;
import com.Springboot.Kirana_Inventory_Management.Repo.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final SaleRepository saleRepo;

    @Override
    public DailySalesReportDTO getDailySalesReport() {
        LocalDate today = LocalDate.now();
        List<Sale> sales = saleRepo.findAll().stream()
                .filter(s -> s.getSaleDate().toLocalDate().equals(today))
                .collect(Collectors.toList());

        int totalItems = sales.stream()
                .flatMap(sale -> sale.getItems().stream())
                .mapToInt(SaleItem::getQuantity)
                .sum();

        double totalAmount = sales.stream().mapToDouble(Sale::getTotalAmount).sum();

        return DailySalesReportDTO.builder()
                .date(today.format(DateTimeFormatter.ISO_DATE))
                .totalOrders(sales.size())
                .totalSales(totalAmount)
                .totalItemsSold(totalItems)
                .build();
    }

    @Override
    public List<DailySalesReportDTO> getMonthlySalesReport() {
        LocalDate now = LocalDate.now();
        return saleRepo.findAll().stream()
                .filter(s -> s.getSaleDate().getMonth().equals(now.getMonth()))
                .collect(Collectors.groupingBy(s -> s.getSaleDate().toLocalDate()))
                .entrySet().stream()
                .map(entry -> {
                    double total = entry.getValue().stream().mapToDouble(Sale::getTotalAmount).sum();
                    int itemCount = entry.getValue().stream()
                            .flatMap(sale -> sale.getItems().stream())
                            .mapToInt(SaleItem::getQuantity).sum();

                    return DailySalesReportDTO.builder()
                            .date(entry.getKey().toString())
                            .totalSales(total)
                            .totalItemsSold(itemCount)
                            .totalOrders(entry.getValue().size())
                            .build();
                })
                .sorted(Comparator.comparing(DailySalesReportDTO::getDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<TopProductDTO> getTopSellingProducts() {
        Map<String, Integer> productMap = new HashMap<>();

        saleRepo.findAll().stream()
                .flatMap(sale -> sale.getItems().stream())
                .forEach(item -> productMap.merge(item.getProductName(), item.getQuantity(), Integer::sum));

        return productMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .map(e -> new TopProductDTO(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public InvoiceDTO generateInvoice(int saleId) {
        Sale sale = saleRepo.findById(saleId)
                .orElseThrow(() -> new RuntimeException("Sale not found"));

        List<SaleItemResponseDTO> itemResponses = sale.getItems().stream()
                .map(item -> SaleItemResponseDTO.builder()
                        .productId(item.getProductId())
                        .productName(item.getProductName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())
                        .totalPrice(item.getTotalPrice())
                        .build())
                .collect(Collectors.toList());

        return InvoiceDTO.builder()
                .saleId(sale.getId())
                .saleDate(sale.getSaleDate())
                .totalAmount(sale.getTotalAmount())
                .items(itemResponses)
                .build();
    }
}
