package com.todouno.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.DTO.Mensaje;
import com.todouno.model.TypeProduct;
import com.todouno.repositories.IRepoTypeProduct;
/**
 *  clase la cual maneja los tipos de producto de la base de datos en esta gracias a la interfaz de repositorio se realizan los metodos necesarios para la CRUD
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/typeProduct")
public class TypeProductController {
	//atributo el cual genera una instancia de la salida cada vez que se requiere
	@Autowired
	private IRepoTypeProduct iRepoTypeProduct;
	
	/**
	 * metodo el cual lista todos los tipo de producto de la base de datos
	 * @return
	 */
	@GetMapping
	public List<TypeProduct>listar(){
		return iRepoTypeProduct.findAll();
	}
	/**
	 * metodo con el cual se inserta un tipo de producto con la anotacion, solo usuario admin puede realizar dicha operacion
	 * @param typeProduct
	 * @return
	 */
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity insertar(@RequestBody TypeProduct typeProduct){
		if(typeProduct.getNombreTipoProducto()==null||typeProduct.getNombreTipoProducto()=="")
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(typeProduct.getNombreTipoProducto() == null || typeProduct.getNombreTipoProducto()=="")
            return new ResponseEntity(new Mensaje("la descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        if(iRepoTypeProduct.existsByNombreTipoProducto(typeProduct.getNombreTipoProducto()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        iRepoTypeProduct.save(typeProduct);
        return new ResponseEntity(new Mensaje("tipo de producto guardado"), HttpStatus.CREATED);
    }
	/**
	 * metodo para eliminar tipo de producto, teniendo en cuenta que si este tipo de producto hace parte de un producto ya creado, la base de datos arroja error
	 * @param nombre
	 * @return
	 */
	@DeleteMapping(value = "/{nombre}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity eliminar(@PathVariable("id") String nombre) {
	    if(!iRepoTypeProduct.existsByNombreTipoProducto(nombre))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
	    iRepoTypeProduct.deleteByNombreTipoProducto(nombre);
        return new ResponseEntity(new Mensaje("tipo de producto eliminado"), HttpStatus.OK);
    }
	
}
