package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.entity.ProductEntity;
import com.demo.repository.ProductRepository;

@Service
public class ProductService {

	  @Autowired ProductRepository productRepository;

	  public ResponseEntity<ProductEntity> queryById(Long id) {
	    ProductEntity product =
	        productRepository
	            .findById(id)
	            .orElseThrow(() -> new RuntimeException("Verilen id ile eşlenen sonuç bulunamadı"));
	    return ResponseEntity.ok().body(product);
	  }

	  public ResponseEntity<List<ProductEntity>> getAll() {
	    return ResponseEntity.ok().body(productRepository.findAll());
	  }

	  public ResponseEntity<ProductEntity> save(ProductEntity product) {
	    return ResponseEntity.ok().body(productRepository.save(product));
	  }
	  
}
