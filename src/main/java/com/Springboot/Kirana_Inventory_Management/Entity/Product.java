package com.Springboot.Kirana_Inventory_Management.Entity;

import java.util.Date;

import com.Springboot.Kirana_Inventory_Management.Enum.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name ="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	public String name;
	
	public String description;
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	public Category category;
	
	@Column(name = "unit_price")
	public double unitPrice;
	
	  @Temporal(TemporalType.DATE)
	  @Column(name = "expiry_date")
	public Date expiryDate;
	
	public int stock;
	
	
	@Version
	@Column(name = "version")
	private int version;
	
	
	

}
