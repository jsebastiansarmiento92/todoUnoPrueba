package com.todouno.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.DTO.Mensaje;
import com.todouno.model.Ingreso;
import com.todouno.repositories.IRepoIngreso;
/**
 * clase la cual maneja los ingresos de la base de datos enesta gracias a la interfaz de repositorio se realizan los metodos necesarios para la CRUD
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600) //anotacion para dar permisos de metodos (POST,PUT,GET,DELETE) al servidor donde corre el fronend 
@RestController
@RequestMapping("/ingreso")
public class IngresosController {
	
	//atributo el cual genera una instancia del ingreso cada vez que se requiere
	@Autowired
	private IRepoIngreso iRepoIngreso;
	/**
	 * metodo el cual lista todos los ingresos de la base de datos
	 * @return
	 */
	@GetMapping
	public List<Ingreso>listar(){
		
		return iRepoIngreso.findAll();
	}
	/**
	 * metodo con el cual se inserta un ingreso con la anotacion @PreAuthorize limita el rol el cual esta autorizado para insertar ingresos a la base de datos 
	 * @param ingreso
	 * @return retorna respuesta de confirmacion si efectivamente el ingreso fue exitoso
	 */ 
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity insertar(@RequestBody Ingreso ingreso){
	
        iRepoIngreso.save(ingreso);
        return new ResponseEntity(new Mensaje("Ingreso guardado"), HttpStatus.CREATED);
    }
	/**
	 * metodo con el cual devuelve un ingreso buscado por id de este
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Optional<Ingreso> getIngreso(@PathVariable("id") Integer id){
		

		return iRepoIngreso.findById(id);

	}
	/**
	 * metodo el cual modifica el ingreso buscado por id, se espoera que la modificacion no varie del valor 
	 * @param ingreso
	 * @param id
	 * @return
	 */
	@PutMapping ("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity modificar(@RequestBody Ingreso ingreso,@PathVariable("id")Integer id){
		 if(!iRepoIngreso.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe ese ingreso"), HttpStatus.NOT_FOUND);
	      
	        if((Integer)ingreso.getCantidadMovimiento() == null || ingreso.getCantidadMovimiento()==0)
	            return new ResponseEntity(new Mensaje("el valor es obligatorio"), HttpStatus.BAD_REQUEST);
	     
	        Ingreso ingresoUpdate = iRepoIngreso.findById(id).get();
	        ingresoUpdate.setCantidadMovimiento(ingreso.getCantidadMovimiento());
	        iRepoIngreso.save(ingresoUpdate);
	        return new ResponseEntity(new Mensaje("ingreso actualizado"), HttpStatus.CREATED);
	}
}
