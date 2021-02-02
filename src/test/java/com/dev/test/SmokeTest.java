package com.dev.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dev.test.controller.ProductController;

@SpringBootTest
public class SmokeTest {
	
	@Autowired
	private ProductController productController;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(productController).isNotNull();
	}

}
