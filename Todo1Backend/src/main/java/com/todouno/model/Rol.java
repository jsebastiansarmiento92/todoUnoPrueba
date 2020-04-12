package com.todouno.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;
/**clase modelo donde define atributos de la entidad del rol de usuarios
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Entity
public class Rol {
	//atributo donde guarda el identificador unico del rol
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	//atributo donde guarda el nombre del rol del usuario (esto define que tipo de rol puede ser un usuario)
	@Enumerated(EnumType.STRING)
	@NotNull
	private RolName rolNombre;

	/**
	 * constructor por defecto para ahcer memoria de la instancia de rol
	 */
	public Rol() {
	}
	/**
	 * constructor donde ingresa por parametro el nombre y lo guarda al atributo rolNombre en la instancia
	 * @param rolNombre
	 */
	public Rol(@NotNull RolName rolNombre) {
		this.rolNombre = rolNombre;
	}
	//metodos set y get 
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */
	public RolName getRolNombre() {
		return rolNombre;
	}
	/**
	 * 
	 * @param rolNombre
	 */
	public void setRolNombre(RolName rolNombre) {
		this.rolNombre = rolNombre;
	}
}