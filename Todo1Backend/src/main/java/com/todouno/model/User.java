package com.todouno.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;
/**clase modelo donde define atributos del usuario a registrar en la tabla usuarios en la base de datos
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Entity
public class User {
	//atributo donde guarda el identificador unico del usuario a guardar en la base de datos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//atributo donde guarda el nombre de usuario real
	@NotNull
	private String nombre;
	//atributo donde guarda el nickname o nombre de usuario en el sistema, debe ser unico
	@NotNull
	@Column(unique = true)
	private String nombreUsuario;
	//atributo donde guarda el email del usuario este debe ser unico
	@NotNull
	@Column(unique = true)
	private String email;
	//atributo donde guarda la contraseña del usuario teniendo en cuenta que la contraseña es encriptada
	@NotNull
	private String password;
	//atributo donde guarda los roles en este caso crea una entidad debil ya que es una relacion de muchos a muchos
	@NotNull
	@ManyToMany
	private Set<Rol> roles = new HashSet<>();

	/**
	 * Contructor por defecto para crear memoria y poder ingresar datos del usuario 
	 */
	public User() {
	}
	/**
	 * Constrctor inicializando todos los atributos y guardandolos en la instancia 
	 * @param nombre
	 * @param nombreUsuario
	 * @param email
	 * @param password
	 */
	public User(@NotNull String nombre, @NotNull String nombreUsuario, @NotNull String email, @NotNull String password) {
		//guardado de datos entrantes por parametro a la instancia de User
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
	}
	//respectivos get y set
	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
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
	public Set<Rol> getRoles() {
		return roles;
	}
	/**
	 * 
	 * @param roles
	 */
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}