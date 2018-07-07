package com.siddheytest.service;

import com.siddheytest.model.Product;

public interface ProductService {
	
	Iterable<Product> listAllProducts();
	
	Product create(Product product);
	
	Product update(Long id,Product product);
	
	void delete(Long id);
	
	Product findById(Long id);

}
