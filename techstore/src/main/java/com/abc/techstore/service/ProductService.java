package com.abc.techstore.service;

import java.util.Optional;

import com.abc.techstore.entity.ProductEntity;
import com.abc.techstore.exception.ProductAlreadyExistingException;
import com.abc.techstore.exception.ProductNotFoundException;
import com.abc.techstore.model.Product;

public interface ProductService {
	public void saveProduct(Product product) throws ProductAlreadyExistingException;
	
}
