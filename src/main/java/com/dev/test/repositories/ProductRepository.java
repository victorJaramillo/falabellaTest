package com.dev.test.repositories;

import org.springframework.data.repository.CrudRepository;

import com.dev.test.entities.ProductEntity;


public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

}
