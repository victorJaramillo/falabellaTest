package com.dev.test.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6307967448430239286L;
	
	
	@Id
	@Column(name="sku", nullable = false)
	private Long sku;
	
	@NotBlank(message = "name is mandatory")
	@Column(name="name", nullable = false)
	private String name;
	
	@NotBlank(message = "brand is mandatory")
	@Column(name="brand", nullable = false)
	private String brand;
	
	@Column(name="size", nullable = true)
	private String size;
	
	@Column(name="price", nullable = false)
	private Long price;

	@NotBlank(message = "principalImage is mandatory")
	@Column(name="principalImage", nullable = false)
	private String principalImage;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="product_sku", referencedColumnName="sku")
	private List<ProductImagesEntity> otherImages;
	

}
