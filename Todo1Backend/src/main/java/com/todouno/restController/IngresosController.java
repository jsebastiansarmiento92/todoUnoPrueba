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

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/ingreso")
public class IngresosController {
	
	
	@Autowired
	private IRepoIngreso iRepoIngreso;
	
	@GetMapping
	public List<Ingreso>listar(){
		
		return iRepoIngreso.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity insertar(@RequestBody Ingreso ingreso){
	
        iRepoIngreso.save(ingreso);
        return new ResponseEntity(new Mensaje("Ingreso guardado"), HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/{id}")
	public Optional<Ingreso> getIngreso(@PathVariable("id") Integer id){
		

		return iRepoIngreso.findById(id);

	}
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
