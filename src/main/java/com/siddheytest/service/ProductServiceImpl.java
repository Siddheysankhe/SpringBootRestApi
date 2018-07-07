package com.siddheytest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.siddheytest.model.Product;
import com.siddheytest.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private static Map<Long, Product> products = new HashMap<Long, Product>();
	private static Long idIndex = 3L;
	
	
	//way 1
	
	// @Autowired
	// private ProductRepository productRepository;
	
	// constructor injection
	
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}


	// setter injection

	// @Autowired
	// public void setProductRepository(ProductRepository productRepository) {
	// this.productRepository = productRepository;
	// }

	// static {
	//
	// Product a = new Product(1L, "Shampoo", "Hair Care", "Good");
	// products.put(1L, a);
	//
	// Product b = new Product(2L, "Biscuit", "Food", "Good");
	// products.put(2L, b);
	//
	// Product c = new Product(3L, "Disinfectant", "Cleaning", "Good");
	// products.put(3L, c);
	//
	// }

	public Iterable<Product> listAllProducts() {
		// return new ArrayList<Product>(products.values()); //for static data

		return productRepository.findAll(); // for mysql data
	}

	public Product create(Product product) {
		// idIndex += 1;
		// product.setId(idIndex);
		// products.put(idIndex, product); //for static stub data

		productRepository.save(product); // for mysql

		// System.out.println(product.getId());

		return product;
	}

	public Product update(Long id, Product product) {
		// products.put(id, product); //for static data

		if (productRepository.exists(id)) {
			productRepository.save(product);
		}

		return product;
	}

	public void delete(Long id) {

		if (productRepository.exists(id)) {
			System.out.println("Present");
		}

		productRepository.delete(id);

		// return products.remove(id);
	}

	public Product findById(Long id) {

		if (productRepository.exists(id)) {
			return productRepository.getOne(id);
		}

		return null;
	}

}
