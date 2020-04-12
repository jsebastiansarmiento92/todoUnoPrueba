package com.todouno.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todouno.DTO.Mensaje;
import com.todouno.model.Product;
import com.todouno.repositories.IRepoProduct;






@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private IRepoProduct iRepoProduct;
	
	@GetMapping
	public List<Product>listar(){
		return iRepoProduct.findAll();
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity insertar(@RequestBody Product product){
		if(product.getName_product()==null||product.getName_product()=="")
            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if((Integer)product.getPrice_product() == null || product.getPrice_product()==0)
            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iRepoProduct.existsByNameProduct(product.getName_product()))
            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        iRepoProduct.save(product);
        return new ResponseEntity(new Mensaje("producto guardado"), HttpStatus.CREATED);
    }
	
	@GetMapping(value = "/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Integer id){
		
		//if(!iRepoProduct.existsById(id))
          //  return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
     //   Product product = iRepoProduct.getOne(id);
     //   return new ResponseEntity<Product>(product, HttpStatus.OK);
		return iRepoProduct.findById(id);
	}
	
	@GetMapping("/nombre/{id}")
	public Product getProduct(@PathVariable("id") String nombre){
		
		//if(!iRepoProduct.existsById(id))
          //  return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
     //   Product product = iRepoProduct.getOne(id);
     //   return new ResponseEntity<Product>(product, HttpStatus.OK);
		return iRepoProduct.findByNameProduct(nombre);
	}
	
	
	@PutMapping ("/{id}")
//	@PreAuthorize("hasRole('ADMIN','USER')") Pendiente por verificar hasta que punto o campos puede modificar el usuario a parte del stock de compra
	public ResponseEntity modificar(@RequestBody Product product,@PathVariable("id")Integer id){
		 if(!iRepoProduct.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
	        if(product.getName_product()==null||product.getName_product()=="")
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if((Integer)product.getPrice_product() == null || product.getPrice_product()==0)
	            return new ResponseEntity(new Mensaje("el precio es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(iRepoProduct.existsByNameProduct(product.getName_product()) &&
	        		iRepoProduct.findByNameProduct(product.getName_product()).getId_product()!= id)
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        Product prodUpdate = iRepoProduct.findById(id).get();
	        prodUpdate.setName_product(product.getName_product());
	        prodUpdate.setPrice_product(product.getPrice_product());
	        prodUpdate.setStock(product.getStock());
	        prodUpdate.setType_product(product.getType_product());
	        prodUpdate.setCost_product(product.getCost_product());
	        iRepoProduct.save(prodUpdate);
	        return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity eliminar(@PathVariable("id") Integer id) {
	    if(!iRepoProduct.existsById(id))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
	    iRepoProduct.deleteById(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }
	}

