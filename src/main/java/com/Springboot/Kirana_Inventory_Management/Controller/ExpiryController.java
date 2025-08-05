package com.Springboot.Kirana_Inventory_Management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;
import com.Springboot.Kirana_Inventory_Management.Service.ExpiryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expiry")
@RequiredArgsConstructor
public class ExpiryController {

    private final ExpiryService expiryService;

    @GetMapping("/soon/{days}")
    public ResponseEntity<List<ProductDTO>> getExpiringSoon(@PathVariable int days) {
        return ResponseEntity.ok(expiryService.getExpiringSoon(days));
    }

    @GetMapping("/expired")
    public ResponseEntity<List<ProductDTO>> getExpired() {
        return ResponseEntity.ok(expiryService.getExpiredProducts());
    }
}
