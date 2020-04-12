package com.todouno.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;
/**clase modelo donde define atributos  del producto a ingresar, tambien puede ser un servicio
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 * @version 12/04/2020
 */
@Entity
@Table(name = "product")
public class Product {
	//atributo donde guarda el identificador o id unico del producto
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_product;
	//atributo donde se guarda el nombre del producto
	@NotBlank
	@Column(unique = true)
	private String nameProduct;
	//atributo donde se guarda el precio unitario del producto
	@NotNull
	private int priceProduct;
	//atributo donde guarda la informacion del producto por defecto en la base de datos estan varios caracteres al azar
	@NotBlank
	private String infoProduct; 
	//atributo donde guarda el stock o el inventario por defecto cuando se crea en la base de datos es (0)
	@NotNull
	private int stock;
	//atributo donde guarda la fecha y hora de ingreso de dicho producto al sistema
	@Temporal(TemporalType.DATE)
	private Calendar date_registro_pro;
	//atributo donde se debe ingresar a que tipo de producto pertenece este producto es un string que funciona como llave foranea de un tipo de producto ya agregado anteriormente
	@NotBlank
	private String type_product;
	//atributo donde deberia guardar la imagen del producto (funcion actualmente no implementada)
	@NotBlank
	private String image_product;
	//atributo donde guarda el costo del producto (cuanto cuesta comprado desde el proveedor)
	@NotNull
	private int cost_product;

	//respectivos metodos set y get 
	/**
	 * 
	 * @return
	 */
	public int getId_product() {
		return id_product;
	}
	/**
	 * 
	 * @param id_product
	 */
	public void setId_product(int id_product) {
		this.id_product = id_product;
	}
	/**
	 * 
	 * @return
	 */
	public String getName_product() {
		return nameProduct;
	}
	/**
	 * 
	 * @param name_product
	 */
	public void setName_product(String name_product) {
		this.nameProduct = name_product;
	}
	/**
	 * 
	 * @return
	 */
	public int getPrice_product() {
		return priceProduct;
	}
	/**
	 * 
	 * @param price_product
	 */
	public void setPrice_product(int price_product) {
		this.priceProduct = price_product;
	}
	/**
	 * 
	 * @return
	 */
	public String getInfo_product() {
		return infoProduct;
	}
	/**
	 * 
	 * @param info_product
	 */
	public void setInfo_product(String info_product) {
		this.infoProduct = info_product;
	}
	/**
	 * 
	 * @return
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * 
	 * @return
	 */
	public Calendar getDate_registro_pro() {
		return date_registro_pro;
	}
	/**
	 * 
	 * @param date_registro_pro
	 */
	public void setDate_registro_pro(Calendar date_registro_pro) {
		this.date_registro_pro = date_registro_pro;
	}
	/**
	 * 
	 * @return
	 */
	public String getType_product() {
		return type_product;
	}
	/**
	 * 
	 * @param type_product
	 */
	public void setType_product(String type_product) {
		this.type_product = type_product;
	}
	/**
	 * 
	 * @return
	 */
	public String getImage_product() {
		return image_product;
	}
	/**
	 * 
	 * @param image_product
	 */
	public void setImage_product(String image_product) {
		this.image_product = image_product;
	}
	/**
	 * 
	 * @return
	 */
	public int getCost_product() {
		return cost_product;
	}
	/**
	 * 
	 * @param cost_product
	 */
	public void setCost_product(int cost_product) {
		this.cost_product = cost_product;
	}

}
