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
	/**
	 * define el metodo buscar por nombre de producto (internamente JPA hace un select user y el where lo toma implicitamente por NombreTipoProducto) retorna 
	 * un producto si lo encuentra
	 * @param nombre
	 * @return
	 */
	Product findByNameProduct(String nombre);
	/**
	* define el metodo buscar por nombre de producto (internamente JPA hace un select user y el where lo toma implicitamente por NombreTipoProducto) retorna 
	 * un verdadero o falso si lo encuentra o no
	 * @param nombre
	 * @return
	 */
	public boolean existsByNameProduct(String nombre);

}
