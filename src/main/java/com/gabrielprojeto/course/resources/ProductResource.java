package com.gabrielprojeto.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielprojeto.course.entities.Product;
import com.gabrielprojeto.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
/* Para "dizer" que a classe é um recurso web 
que é implementado por um controlador rest */
public class ProductResource {
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}//Controlador Rest com valor Product
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product Product = service.findById(id);
		return ResponseEntity.ok().body(Product);
	}
	
	
}
