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

@Entity
@Table(name = "ingreso")
public class Ingreso {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idIngreso;
	
	@NotNull
	private int idProductIdIngreso;
	
	@Temporal(TemporalType.DATE)
    private Calendar fechaIngreso;
	
	@NotNull
	private int cantidadMovimiento;
	
	@NotBlank
	private String motivo;

	public int getIdIngreso() {
		return idIngreso;
	}

	public void setIdIngreso(int idIngreso) {
		this.idIngreso = idIngreso;
	}

	public int getIdProductIdIngreso() {
		return idProductIdIngreso;
	}

	public void setIdProductIdIngreso(int idProductIdIngreso) {
		this.idProductIdIngreso = idProductIdIngreso;
	}

	public Calendar getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Calendar fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCantidadMovimiento() {
		return cantidadMovimiento;
	}

	public void setCantidadMovimiento(int cantidadMovimiento) {
		this.cantidadMovimiento = cantidadMovimiento;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
	
	

}
