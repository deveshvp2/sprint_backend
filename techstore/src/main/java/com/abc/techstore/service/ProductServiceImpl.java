package com.abc.techstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.techstore.entity.ProductEntity;
import com.abc.techstore.exception.ProductAlreadyExistingException;
import com.abc.techstore.exception.ProductNotFoundException;
import com.abc.techstore.model.Product;
import com.abc.techstore.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void saveProduct(Product product) throws ProductAlreadyExistingException {

		Optional<ProductEntity> optionalProduct = productRepository.findById(product.getProductId());

		if(optionalProduct.isPresent()) {
			throw new ProductAlreadyExistingException("Product already existing with id: "+product.getProductId());
		}else {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(product.getProductId());
			productEntity.setProductName(product.getProductName());
			productEntity.setProductPrice(product.getProductPrice());
			productEntity.setProductDescription(product.getProductDescription());
			productEntity.setProductDom(product.getProductDom());
			productRepository.save(productEntity);
			
		}
	}

	
		
	
}


