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
	/**
	 * define el metodo buscar por nombre de tipo de producto (internamente JPA hace un select user y el where lo toma implicitamente por NombreTipoProducto) retorna 
	 * verdadero o falso si lo encuentra o no
	 * @param nombre
	 * @return
	 */
	public boolean existsByNombreTipoProducto(String nombre);
	/**
	 * define el metodo eliminar por nombre de tipo de producto (internamente JPA hace un select user y el where lo toma implicitamente por NombreTipoProducto)
	 * @param nombre
	 */
	public void deleteByNombreTipoProducto(String nombre);
	

}
