package com.siddheytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siddheytest.model.Product;
import com.siddheytest.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	// way 1 @Autowired

	// @Autowired
	// private ProductService productService;

	// way 2 constructor injection

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	// way 3 setter injection

	// @Autowired
	// public void setProductService(ProductService productService) {
	// this.productService = productService;
	// }

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Iterable<Product> list() {
		// ArrayList<Product> arrlist = new ArrayList();

		return productService.listAllProducts();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		System.out.println(product.getConditionOfProduct() + "  " + product.getDescription() + " " + product.getName());
		return productService.create(product);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public Product update(@PathVariable Long id, @RequestBody Product product) {
		return productService.update(id, product);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		productService.delete(id);

	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return productService.findById(id);
	}

}
