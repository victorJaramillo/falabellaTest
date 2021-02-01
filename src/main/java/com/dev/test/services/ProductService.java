package com.dev.test.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.test.entities.ProductEntity;
import com.dev.test.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public List<ProductEntity> getProducts() {
		return (List<ProductEntity>) repository.findAll();
	}
	
	public ProductEntity findProductBySku(Long sku) {
		return repository.findById(sku).get();
	}
	
	public ProductEntity saveProduct(ProductEntity productEntity) {
		return repository.save(productEntity);
	}

}
