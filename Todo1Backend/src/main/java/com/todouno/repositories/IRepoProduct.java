package com.todouno.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Product;


@Repository
public interface IRepoProduct extends JpaRepository<Product, Integer>{
	
		Product findByNameProduct(String nombre);
		public boolean existsByNameProduct(String nombre);

}
