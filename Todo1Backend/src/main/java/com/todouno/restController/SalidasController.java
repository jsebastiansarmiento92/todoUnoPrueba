package com.todouno.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.DTO.Mensaje;

import com.todouno.model.Salida;
import com.todouno.repositories.IRepoSalida;
/**
 * clase la cual maneja las salidas  de la base de datos enesta gracias a la interfaz de repositorio se realizan los metodos necesarios para la CRUD
 * @author Juan Sebastian Sarmiento jsebastiansarmiento92@gmail.com
 *
 * @version 12/04/2020
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/salidas")
public class SalidasController {
	//atributo el cual genera una instancia de la salida cada vez que se requiere
	@Autowired
	private IRepoSalida repoSalida;
	
	/**
	 * metodo el cual lista todas salidas de la base de datos
	 * @return
	 */
	@GetMapping
	public List<Salida>listar(){
		
		return repoSalida.findAll();
	}
	/**
	 * metodo con el cual se inserta una salida con la anotacion, en este caso no limita quien puede hacer una insercion de salida ya que usuario comun puede realizar a la hora de compra
	 * @param salida
	 * @return
	 */
	@PostMapping
	public ResponseEntity insertar(@RequestBody Salida salida){
		System.out.println("salida a guardad id "+ salida.getIdProductIdSalida()+" valor "+salida.getCantidadSalida());
		repoSalida.save(salida);
        return new ResponseEntity(new Mensaje("Salida guardada"), HttpStatus.CREATED);

    }
	/**
	 * metodo con el cual devuelve una salida buscado por id de esta ()
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Optional<Salida> getSalida(@PathVariable("id") Integer id){
		

		return repoSalida.findById(id);

	}
	/**
     * metodo el cual modifica la salida buscado por id.
	 * @param salida
	 * @param id
	 * @return
	 */
	@PutMapping ("/{id}")
	public ResponseEntity modificar(@RequestBody Salida salida,@PathVariable("id")Integer id){
		 if(!repoSalida.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe ese ingreso"), HttpStatus.NOT_FOUND);
	      
	        if((Integer)salida.getCantidadSalida() == null || salida.getCantidadSalida()==0)
	            return new ResponseEntity(new Mensaje("el valor es obligatorio"), HttpStatus.BAD_REQUEST);
	     
	        Salida salidaUpdate = repoSalida.findById(id).get();
	        salidaUpdate.setCantidadSalida(salida.getCantidadSalida());
	        repoSalida.save(salidaUpdate);
	        return new ResponseEntity(new Mensaje("ingreso actualizado"), HttpStatus.CREATED);
	}
	
	
	
}
