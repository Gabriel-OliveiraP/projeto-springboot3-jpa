package com.gabrielprojeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielprojeto.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
