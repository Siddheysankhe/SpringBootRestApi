package com.siddheytest.Test.contoller;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.siddheytest.controller.ProductController;
import com.siddheytest.model.Product;
import com.siddheytest.service.ProductService;


@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class,secure = false)
public class ProductControllerTest{
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	String exampleProduct = "{\"id\":9,\"name\":\"sid_test9\",\"description\":\"random_desc9\",\"conditionOfProduct\":\"random_cond9\"}";
	
	@Test
	public void testList() throws Exception{
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/list").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		
		
		
	}
	
	@Test
	public void addProduct() throws Exception{
		
		Product mockProduct = new Product(8L,"Laptop","Acer Laptop","Good");
		
		Mockito.when(productService.create(Mockito.any(Product.class))).thenReturn(mockProduct);
		
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/add")
										.accept(MediaType.APPLICATION_JSON)
										.content(exampleProduct)
										.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
				
		
	}
	
	
	

}
