package com.todouno.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**Clase modelo donde define atributos de la entidad de tipo de producto 
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Entity
public class TypeProduct {

	//atributo donde guarda el identificador unico en este caso a diferencia de los demas identificadores este es con el nombre del producto
	@Id
	private String nombreTipoProducto;
	//atributo donde guarda una descripcion breve del tipo de producto 
	@NotBlank
	private String descrpicionTipoProducto;

	//respectivos set y get
	/**
	 * 
	 * @return
	 */
	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}
	/**
	 * 
	 * @param nombreTipoProducto
	 */
	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescrpicionTipoProducto() {
		return descrpicionTipoProducto;
	}
	/**
	 * 
	 * @param descrpicionTipoProducto
	 */
	public void setDescrpicionTipoProducto(String descrpicionTipoProducto) {
		this.descrpicionTipoProducto = descrpicionTipoProducto;
	}	
}
