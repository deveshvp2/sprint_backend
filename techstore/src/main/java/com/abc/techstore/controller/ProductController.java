package com.abc.techstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.techstore.entity.ProductEntity;
import com.abc.techstore.model.Product;
import com.abc.techstore.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private ProductService productService; 
	
	@PostMapping("/save")
	public ResponseEntity<?> addProduct(@Valid @RequestBody Product product){
		productService.saveProduct(product);
		return new ResponseEntity<>("Product saved successfully",HttpStatus.CREATED	);
	}

	
}