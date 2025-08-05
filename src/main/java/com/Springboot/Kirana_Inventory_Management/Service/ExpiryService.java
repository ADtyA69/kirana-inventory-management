package com.Springboot.Kirana_Inventory_Management.Service;

import java.util.List;

import com.Springboot.Kirana_Inventory_Management.DTO.ProductDTO;

public interface ExpiryService {
	 List<ProductDTO> getExpiringSoon(int daysAhead);
	    List<ProductDTO> getExpiredProducts();
}
