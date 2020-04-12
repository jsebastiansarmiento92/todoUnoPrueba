package com.todouno.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Product;

/**
 * Interfaz que mapea los Productos a la base de datos (en esta interfaz define la CRUD como tal)
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Repository
public interface IRepoProduct extends JpaRepository<Product, Integer>{
	
		Product findByNameProduct(String nombre);
		public boolean existsByNameProduct(String nombre);

}
