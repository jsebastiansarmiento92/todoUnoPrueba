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
	/**
	 * define el metodo eliminar por nombre de rol (internamente JPA hace un select user y el where lo toma implicitamente por RolNombre) retorna el rol si lo encuentra
	 * @param rolNombre
	 * @return
	 */
	Optional<Rol> findByRolNombre(RolName rolNombre);
	
}
