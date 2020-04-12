package com.todouno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.TypeProduct;

@Repository
public interface IRepoTypeProduct extends JpaRepository<TypeProduct, Integer> {
	
	public boolean existsByNombreTipoProducto(String nombre);
	public void deleteByNombreTipoProducto(String nombre);
	

}
