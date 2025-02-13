package com.gabrielprojeto.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gabrielprojeto.course.entities.User;
import com.gabrielprojeto.course.repositories.UserRepository;
import com.gabrielprojeto.course.services.exceptions.DatabaseException;
import com.gabrielprojeto.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
	    if (!repository.existsById(id)) {
	        throw new ResourceNotFoundException(id);
	    }
	    try {
	        repository.deleteById(id);
	    } catch (EmptyResultDataAccessException e) {
	        throw new ResourceNotFoundException(id);
	    }catch(DataIntegrityViolationException e){
	    	throw new DatabaseException(e.getMessage());
	    }
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = repository.getReferenceById(id);
		// É como o findById, mas ao invez de ele pegar
		//diretamente o user pelo id, ele prepara apenas e depois commita
		updateData(entity, obj);
		//metodo que recebe o User a ser atualizado e o novo
		return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());	
	}
}
