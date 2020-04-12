package com.todouno.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**Clase donde define atributos del nuevo usuario o usuario a registrarse (esta clase no es una entidad de base de datos solo se guarda para verificar )
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 * @version 12/04/2020
 */
public class NewUser {
	//atributo donde guarda nombre del usuario (nombre real)
	@NotBlank
	private String nombre;
	//atributo donde guarda el email del usuario con el cual se tiene que registrar (el email es unico) se restringe en la base de datos 
	@NotBlank
	@Email
	private String email;
	//atriburo donde guarda el nickname del usuario (nombre de usuario a eleccion)
	@NotBlank
	private String nombreUsuario;
	//atributo donde guarda la contraseña del usuario
	@NotBlank
	private String password;
	//atributo donde se guardan los diferentes roles o permisos que tiene dicho usuario
	private Set<String> roles;

	//respectivos metodos set y get
	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 
	 * @return
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	/**
	 * 
	 * @param nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return
	 */
	public Set<String> getRoles() {
		return roles;
	}
	/**
	 * 
	 * @param roles
	 */
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
