package com.ann.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ann.product.entity.Product;
import com.ann.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts(){
		List<Product> product = productRepository.findAll();
		return product;
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

}
