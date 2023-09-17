package com.prowings.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prowings.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

////	public List<Product> getAllProductsFromDb();
//
//	public boolean createProduct(Product product);
	
	public List<Product> findByName(String name);

}
