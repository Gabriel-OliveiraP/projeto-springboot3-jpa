package com.gabrielprojeto.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielprojeto.course.entities.User;

@RestController
@RequestMapping(value = "/users")
/* Para "dizer" que a classe é um recurso web 
que é implementado por um controlador rest */
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Maria", "maria@gmail.com", "123123", "123");
		return ResponseEntity.ok().body(u);
	}//Controlador Rest com valor User
	
}
