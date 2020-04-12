package com.todouno.model;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;


@Entity
public class TypeProduct {

	
	@Id
	private String nombreTipoProducto;
	
	@NotBlank
	private String descrpicionTipoProducto;

	public String getNombreTipoProducto() {
		return nombreTipoProducto;
	}

	public void setNombreTipoProducto(String nombreTipoProducto) {
		this.nombreTipoProducto = nombreTipoProducto;
	}

	public String getDescrpicionTipoProducto() {
		return descrpicionTipoProducto;
	}

	public void setDescrpicionTipoProducto(String descrpicionTipoProducto) {
		this.descrpicionTipoProducto = descrpicionTipoProducto;
	}
	
	
	
	
	
}