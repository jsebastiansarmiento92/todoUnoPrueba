package com.todouno.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todouno.model.User;
/**
 * Interfaz que mapea los Usuarios a la base de datos (en esta interfaz define la CRUD como tal)
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Repository
public interface IRepoUser extends JpaRepository<User, Integer>{
	/**
	 * define el metodo buscar por nombre de usuario (internamente JPA hace un select user y el where lo toma implicitamente por NombreUsuario) retorna un usuario en caso de encontrarlo
	 * @param nu
	 * @return
	 */
	Optional<User> findByNombreUsuario(String nu);
	/**
	 * define el metodo buscar por nombre de usuario (internamente JPA hace un select user y el where lo toma implicitamente por NombreUsuario) retorna falso o verdadero si no lo encuentra o si
	 * @param nu
	 * @return
	 */
    boolean existsByNombreUsuario(String nu);
    /**
     * define el metodo buscar por email de usuario (internamente JPA hace un select user y el where lo toma implicitamente por Email) retorna verdadero o falso dependiente si existe el email ya
     * en la base de datos
     * @param email
     * @return
     */
    boolean existsByEmail(String email);
		
}
