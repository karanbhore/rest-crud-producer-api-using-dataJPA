package com.prowings.service;

import java.util.List;

import com.prowings.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProducts();

	public boolean createProduct(Product product);

	public Product getProductById(int id);

	public List<Product> getProductByName(String name);

	public List<Product> getAllProductsSorted(String sortBy, String sortDir);

	public List<Product> getAllProductsSortedAndPaginated(int pageSize, int pageNo, String sortBy, String sortDir);

	public boolean updateProduct(Product product, int id);

	public boolean deleteProduct(int id);

	public boolean createMultipleProducts(List<Product> products);


}
