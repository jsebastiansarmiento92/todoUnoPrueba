package com.todouno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.Rol;
import com.todouno.model.RolName;
/**
 * Interfaz que mapea los Roles a la base de datos (en esta interfaz define la CRUD como tal)
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Repository
public interface IRepoRol extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByRolNombre(RolName rolNombre);
	
}
