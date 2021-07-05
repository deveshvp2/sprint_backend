package com.abc.techstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.techstore.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>{

}
