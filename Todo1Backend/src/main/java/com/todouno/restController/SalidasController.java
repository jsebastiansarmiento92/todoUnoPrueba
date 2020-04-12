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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/salidas")
public class SalidasController {

	@Autowired
	private IRepoSalida repoSalida;
	
	@GetMapping
	public List<Salida>listar(){
		
		return repoSalida.findAll();
	}
	
	@PostMapping
	public ResponseEntity insertar(@RequestBody Salida salida){
		System.out.println("salida a guardad id "+ salida.getIdProductIdSalida()+" valor "+salida.getCantidadSalida());
		repoSalida.save(salida);
        return new ResponseEntity(new Mensaje("Salida guardada"), HttpStatus.CREATED);

    }
	
	@GetMapping(value = "/{id}")
	public Optional<Salida> getSalida(@PathVariable("id") Integer id){
		

		return repoSalida.findById(id);

	}
	
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
