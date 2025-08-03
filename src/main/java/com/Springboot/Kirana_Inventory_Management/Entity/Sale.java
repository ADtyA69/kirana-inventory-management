package com.Springboot.Kirana_Inventory_Management.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter 
@Setter 
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime saleDate;

    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<SaleItem> items = new ArrayList<>();
}
