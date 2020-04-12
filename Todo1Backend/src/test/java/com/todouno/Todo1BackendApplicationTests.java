package com.todouno;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.todouno.model.Product;
import com.todouno.repositories.IRepoProduct;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Todo1BackendApplicationTests {

	@Autowired
	private IRepoProduct repoProduct; 
	
	@Test
	public void createProductTest() {
		Product product = new Product();
		product.setName_product("batman pequeño");
		product.setPrice_product(50000);
		product.setInfo_product("batman de 15 cm originarl");
		product.setStock(30);
		product.setType_product("Coleccionables");
		product.setImage_product("asdasdasdasd");
		product.setCost_product(45000);
		System.out.println("id producto a crear "+product.getId_product());
		Product productConsulta= repoProduct.findByNameProduct(product.getName_product());
		assertTrue(productConsulta==null);
	}
	
	
}
