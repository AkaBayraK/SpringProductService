package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.ProductEntity;
import com.demo.service.ProductService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired ProductService productService;

	  @RequestMapping(value = "/test", method = RequestMethod.GET)
	  @Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	  @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN, MediaType.APPLICATION_XML })
	  public String testService() {
		  //biraz önce belirttimiz gibi ilk build ettiğimizde
		  //bu şekilde edeceğiz sonrasında ise (return "Product Service 2";)
		  //olarak build edeceğiz.
		  return "Product Service 1";
	  }	
	
	  @GetMapping("{id}")
	  public ResponseEntity<ProductEntity> queryById(@PathVariable("id") Long id) {
	    return productService.queryById(id);
	  }

	  @GetMapping
	  public ResponseEntity<List<ProductEntity>> getAll() {
	    return productService.getAll();
	  }

	  @PostMapping
	  public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product) {
	    return productService.save(product);
	  }
	  

}
