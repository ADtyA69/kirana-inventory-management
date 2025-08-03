package com.Springboot.Kirana_Inventory_Management.DTO;

import java.util.Date;

import com.Springboot.Kirana_Inventory_Management.Enum.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

	
		private int id;
	    private String name;
	    private String description;
	    private Category category;
	    private double unitPrice;
	    private Date expiryDate;
	    private int stock;
}
