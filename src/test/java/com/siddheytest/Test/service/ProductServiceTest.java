package com.siddheytest.Test.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.siddheytest.model.Product;
import com.siddheytest.repository.ProductRepository;
import com.siddheytest.service.ProductServiceImpl;


@RunWith(SpringRunner.class)
public class ProductServiceTest {
	
	private ProductServiceImpl productServiceImpl;
	
	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private Product product;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		productServiceImpl = new ProductServiceImpl(productRepository);
		//productServiceImpl.setProductRepository(productRepository);
	}
	
	@Test
	public void testListAllProducts() throws Exception{
		
		when(productRepository.findOne(5L)).thenReturn(product);
		
		Product retrievedProduct = productServiceImpl.findById(5L);
		
		assertThat(retrievedProduct,is(equalTo(product)));
	}

//	@Test
//	public void testCreate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testUpdate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

}
