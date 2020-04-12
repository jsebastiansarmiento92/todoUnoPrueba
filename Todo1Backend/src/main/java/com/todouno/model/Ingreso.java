package com.todouno.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
/**clase modelo donde define atributos de los ingresos o compras a proveedor en la base de datos
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@Entity
@Table(name = "ingreso")
public class Ingreso {
	//atributo donde guarda el identificador o id unico del ingreso o compra
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngreso;
	//atributo donde  hace referencia del producto al que ingresa o aumenta el stock
	@NotNull
	private int idProductIdIngreso;
	//atributo donde guarda la fecha y hora que se hizo dicha compra o ingreso a la base de datos
	@Temporal(TemporalType.DATE)
	private Calendar fechaIngreso;
	//atributo donde guarda la cantida o valor en dinero 
	@NotNull
	private int cantidadMovimiento;
	//atributo donde guarda una breve descripcion de dicho ingreso
	@NotBlank
	private String motivo;

	//respectivos metodos get y set
	/**
	 * 
	 * @return
	 */
	public int getIdIngreso() {
		return idIngreso;
	}
	/**
	 * 
	 * @param idIngreso
	 */
	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}
	/**
	 * 
	 * @return
	 */
	public int getIdProductIdIngreso() {
		return idProductIdIngreso;
	}
	/**
	 * 
	 * @param idProductIdIngreso
	 */
	public void setIdProductIdIngreso(int idProductIdIngreso) {
		this.idProductIdIngreso = idProductIdIngreso;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}
	/**
	 * 
	 * @param fechaIngreso
	 */
	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	/**
	 * 
	 * @return
	 */
	public int getCantidadMovimiento() {
		return cantidadMovimiento;
	}
	/**
	 * 
	 * @param cantidadMovimiento
	 */
	public void setCantidadMovimiento(int cantidadMovimiento) {
		this.cantidadMovimiento = cantidadMovimiento;
	}
	/**
	 * 
	 * @return
	 */
	public String getMotivo() {
		return motivo;
	}
	/**
	 * 
	 * @param motivo
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
}
