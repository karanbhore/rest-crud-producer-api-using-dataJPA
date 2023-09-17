package com.prowings.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.prowings.dao.ProductRepository;
import com.prowings.entity.Product;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		log.info("inside service - getAllProducts()");
		return productRepository.findAll();
	}

	@Override
	public boolean createProduct(Product product) {
		log.info("inside service - createProduct()");
		Product savedProduct = productRepository.save(product);
		return Objects.nonNull(savedProduct);
	}

	@Override
	public boolean updateProduct(Product product, int id) {
		log.info("inside service - updateProduct()");
		Product updatedProduct = productRepository.save(product);
		return Objects.nonNull(updatedProduct);
	}

	@Override
	public boolean deleteProduct(int id) {
		log.info("inside service - deleteProduct()");
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Product getProductById(int id) {
		log.info("inside service - getProductById()");
//		return productRepository.getById(id);
		
		Optional<Product> fetchedProduct = productRepository.findById(id);
		
		return fetchedProduct.get();
	}

	@Override
	public boolean createMultipleProducts(List<Product> products) {
		 log.info("inside service - createMultipleProducts()");
		List<Product> prods=productRepository.saveAll(products);
		if(prods!=null)
			return true;
		else 
			return false;
	}

	@Override
	public List<Product> getProductByName(String name) {
		return productRepository.findByName(name);
	}

	@Override
	public List<Product> getAllProductsSorted(String sortBy, String sortDir) {
		
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
		
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> getAllProductsSortedAndPaginated(int pageSize, int pageNo, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

		// create Pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> paginatedProducts = productRepository.findAll(pageable);
     
//        paginatedProducts.get().
        return new ArrayList<>();
	}

}
