package com.dev.test.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.test.entities.ProductEntity;
import com.dev.test.services.ProductService;

@RestController
@RequestMapping(value="/api/v1/products")
public class ProductController {

	
	@Autowired
	private ProductService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts() {
		List<ProductEntity> resp = service.getProducts();
		
		return reponseUtil(resp, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{sku}",method = RequestMethod.GET)
	public ResponseEntity<Object> findProductBySku(@PathVariable(value = "sku") Long sku){
		Map<String, Object> response = new LinkedHashMap<>();
		ProductEntity productEntity = service.findProductBySku(sku);
		
		if(productEntity != null) {
			return reponseUtil(productEntity, HttpStatus.OK);	
		}else {			
			return reponseUtil(response, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> saveProduct(@Valid @RequestBody ProductEntity entity) {
		Map<String, Object> response = new LinkedHashMap<>();
		ProductEntity productEntity = service.saveProduct(entity);
		if(productEntity != null) {
			return reponseUtil(productEntity, HttpStatus.OK);	
		}else {			
			return reponseUtil(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	private static ResponseEntity<Object> reponseUtil(Object response, HttpStatus httpStatus) {
		return ResponseEntity.status(httpStatus).body(response);
	}
}
