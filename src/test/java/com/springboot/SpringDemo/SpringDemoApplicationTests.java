package com.springboot.SpringDemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springboot.controller.BasicController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

	private MockMvc mockMvc;
	
	@Before
	@Test
	public void contextLoads() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController()).build();
	}
	@Test
	public void basicTest() throws Exception {
	this.mockMvc
	.perform(
	get("/stat")
	.accept(MediaType.parseMediaType
	("application/html;charset=UTF-8")))
	.andExpect(status().isOk())
	.andExpect( content().contentType
	("application/html;charset=UTF-8"))
	.andExpect(content().
	string("App is Up"));
	}
}
