package com.todouno.model;


import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.sun.istack.NotNull;
/**clase modelo donde define atributos
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Entity
public class Salida {
	
	@Id
	private int idSalida;
	@NotNull
	private int idProductIdSalida;
	
	@Temporal(TemporalType.DATE)
	private Calendar fechaSalida;
	@NotNull
	private int cantidadSalida;
	
	private String motivoSalida;
	
	
	
	
	
	
	public int getIdSsalida() {
		return idSalida;
	}
	public void setIdSsalida(int idSsalida) {
		this.idSalida = idSsalida;
	}
	public int getIdProductIdSalida() {
		return idProductIdSalida;
	}
	public void setIdProductIdSalida(int idProductIdSalida) {
		this.idProductIdSalida = idProductIdSalida;
	}
	public Calendar getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public int getCantidadSalida() {
		return cantidadSalida;
	}
	public void setCantidadSalida(int cantidaSalida) {
		this.cantidadSalida = cantidaSalida;
	}
	public String getMotivoSalida() {
		return motivoSalida;
	}
	public void setMotivoSalida(String motivoSalida) {
		this.motivoSalida = motivoSalida;
	}
	
	
	
}
