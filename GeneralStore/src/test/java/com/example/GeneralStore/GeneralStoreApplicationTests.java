package com.example.GeneralStore;

import com.example.GeneralStore.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class GeneralStoreApplicationTests {

	@Autowired
	public ProductService productService;

	@Test
	public void testGetAllProductNames(){
		List<String> names= productService.getAllProductNames();
		System.out.println(names);
	}

	@Test
	void contextLoads() {
	}

}
