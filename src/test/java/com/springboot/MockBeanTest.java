package com.springboot;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springboot.beans.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MockBeanTest {

	@MockBean
	Product product;
	
	@Test
	public void testMockBean() throws Exception {
		when(product.getName()).thenReturn(new Product(0, "I'm a Mock", 0.9f).getName());
		System.out.println(product.getName());
		ObjectMapper mapper =new ObjectMapper();
//		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		String jsonProductString = mapper.writeValueAsString(new Product(0, "I'm a Mock", 0.9f));
		System.out.println("imJson"+jsonProductString);
		JSONAssert.assertEquals("{id:0,name:\"I'm a Mock\",price:0.9}",jsonProductString, false);

	}
	
	
}
