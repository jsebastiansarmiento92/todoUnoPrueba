package com.todouno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.TypeProduct;
/**
* Interfaz que mapea los tipo de producto a la base de datos (en esta interfaz define la CRUD como tal)
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Repository
public interface IRepoTypeProduct extends JpaRepository<TypeProduct, Integer> {
	
	public boolean existsByNombreTipoProducto(String nombre);
	public void deleteByNombreTipoProducto(String nombre);
	

}
