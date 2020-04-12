package com.todouno.model;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.sun.istack.NotNull;
/**clase modelo donde define atributos de la entidad donde registra las salidas de producto de la base de datos
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *(pendiente para tener encuenta si es necesario crear atributo donde guarde cuanto salio del stock)
 * @version 12/04/2020
 */
@Entity
public class Salida {
	//atributo donde guarda el identificador unico de la salida del producto
	@Id
	private int idSalida;
	//atributo donde guarda el identificador del producto de donde se realiza dicha salida
	@NotNull
	private int idProductIdSalida;
	//atributo donde guarda fecha y hora de la salida en la base de datos
	@Temporal(TemporalType.DATE)
	private Calendar fechaSalida;
	//atributo donde guarda la cantidad en dinero de la salida 
	@NotNull
	private int cantidadSalida;
	//atributo donde guarda la descripcion de la salida (por defecto esta en la base de datos "salida por producto")
	private String motivoSalida;


	//respectivos get y set
	/**
	 * 
	 * @return
	 */
	public int getIdSsalida() {
		return idSalida;
	}
	/**
	 * 
	 * @param idSsalida
	 */
	public void setIdSsalida(int idSsalida) {
		this.idSalida = idSsalida;
	}
	/**
	 * 
	 * @return
	 */
	public int getIdProductIdSalida() {
		return idProductIdSalida;
	}
	/**
	 * 
	 * @param idProductIdSalida
	 */
	public void setIdProductIdSalida(int idProductIdSalida) {
		this.idProductIdSalida = idProductIdSalida;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	/**
	 * 
	 * @param fechaSalida
	 */
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	/**
	 * 
	 * @return
	 */
	public int getCantidadSalida() {
		return cantidadSalida;
	}
	/**
	 * 
	 * @param cantidaSalida
	 */
	public void setCantidadSalida(int cantidaSalida) {
		this.cantidadSalida = cantidaSalida;
	}
	/**
	 * 
	 * @return
	 */
	public String getMotivoSalida() {
		return motivoSalida;
	}
	/**
	 * 
	 * @param motivoSalida
	 */
	public void setMotivoSalida(String motivoSalida) {
		this.motivoSalida = motivoSalida;
	}
}
