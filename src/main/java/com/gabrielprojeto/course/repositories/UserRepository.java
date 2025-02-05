package com.gabrielprojeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielprojeto.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	/*
	 * Não precisamos colocar os métodos, pq o SpringDataJpa já tem
	 * a implementação padrão para isso.
	 */
}
