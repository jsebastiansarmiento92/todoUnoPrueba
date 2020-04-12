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
	
    @NotBlank
    @Column(unique = true)
    private String nameProduct;
    
    @NotNull
    private int priceProduct;
    
    @NotBlank
    private String infoProduct; 
    
    @NotNull
    private int stock;
    
  
    @Temporal(TemporalType.DATE)
    private Calendar date_registro_pro;
    
    @NotBlank
    private String type_product;

    @NotBlank
    private String image_product;
    
    @NotNull
    private int cost_product;
    
   
    
    

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public String getName_product() {
		return nameProduct;
	}

	public void setName_product(String name_product) {
		this.nameProduct = name_product;
	}

	public int getPrice_product() {
		return priceProduct;
	}

	public void setPrice_product(int price_product) {
		this.priceProduct = price_product;
	}

	public String getInfo_product() {
		return infoProduct;
	}

	public void setInfo_product(String info_product) {
		this.infoProduct = info_product;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Calendar getDate_registro_pro() {
		return date_registro_pro;
	}

	public void setDate_registro_pro(Calendar date_registro_pro) {
		this.date_registro_pro = date_registro_pro;
	}

	public String getType_product() {
		return type_product;
	}

	public void setType_product(String type_product) {
		this.type_product = type_product;
	}

	public String getImage_product() {
		return image_product;
	}

	public void setImage_product(String image_product) {
		this.image_product = image_product;
	}

	public int getCost_product() {
		return cost_product;
	}

	public void setCost_product(int cost_product) {
		this.cost_product = cost_product;
	}

	
    
}
