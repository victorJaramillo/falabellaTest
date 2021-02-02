package com.dev.test.services;

import java.util.List;
import java.util.Optional;

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
		Optional<ProductEntity> response = repository.findById(sku);
		return response.isPresent() ? response.get(): null;
	}
	
	public ProductEntity saveProduct(ProductEntity productEntity) {
		Object findExistentProduct = findProductBySku(productEntity.getSku());
		if(null == findExistentProduct) {			
			productEntity.getOtherImages().forEach(data -> {
				data.setProductSku(productEntity.getSku());
			});
			return repository.save(productEntity);
		}else {
			return null;
		}
	}

}
