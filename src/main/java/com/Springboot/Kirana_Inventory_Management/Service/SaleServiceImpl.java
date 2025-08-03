package com.Springboot.Kirana_Inventory_Management.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleItemRequestDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleItemResponseDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleRequestDTO;
import com.Springboot.Kirana_Inventory_Management.DTO.SaleResponseDTO;
import com.Springboot.Kirana_Inventory_Management.Entity.Sale;
import com.Springboot.Kirana_Inventory_Management.Entity.SaleItem;
import com.Springboot.Kirana_Inventory_Management.Repo.SaleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepo;
    private final ProductService productService;

    @Override
    public SaleResponseDTO createSale(SaleRequestDTO saleRequestDTO) {
        List<SaleItem> saleItems = new ArrayList<>();
        double totalAmount = 0;

        for (SaleItemRequestDTO itemReq : saleRequestDTO.getItems()) {
            ProductDTO product = productService.getProductById(itemReq.getProductId());

            if (product.getStock() < itemReq.getQuantity()) {
                throw new RuntimeException("Insufficient stock for product: " + product.getName());
            }

            double itemTotal = itemReq.getQuantity() * product.getUnitPrice();
            totalAmount += itemTotal;

            SaleItem item = SaleItem.builder()
                    .productId(product.getId())
                    .productName(product.getName())
                    .quantity(itemReq.getQuantity())
                    .unitPrice(product.getUnitPrice())
                    .totalPrice(itemTotal)
                    .build();

            // Decrement stock
            product.setStock(product.getStock() - itemReq.getQuantity());
            productService.updateProduct(product.getId(), product);

            saleItems.add(item);
        }

        Sale sale = Sale.builder()
                .saleDate(LocalDateTime.now())
                .totalAmount(totalAmount)
                .items(saleItems)
                .build();

        saleItems.forEach(item -> item.setSale(sale));

        Sale savedSale = saleRepo.save(sale);

        return mapToResponse(savedSale);
    }

    @Override
    public SaleResponseDTO getSaleById(int id) {
        Sale sale = saleRepo.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
        return mapToResponse(sale);
    }

    @Override
    public List<SaleResponseDTO> getAllSales() {
        return saleRepo.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private SaleResponseDTO mapToResponse(Sale sale) {
        List<SaleItemResponseDTO> itemResponses = sale.getItems().stream()
                .map(item -> SaleItemResponseDTO.builder()
                        .productId(item.getProductId())
                        .productName(item.getProductName())
                        .quantity(item.getQuantity())
                        .unitPrice(item.getUnitPrice())
                        .totalPrice(item.getTotalPrice())
                        .build())
                .collect(Collectors.toList());

        return SaleResponseDTO.builder()
                .id(sale.getId())
                .saleDate(sale.getSaleDate())
                .totalAmount(sale.getTotalAmount())
                .items(itemResponses)
                .build();
    }
}
