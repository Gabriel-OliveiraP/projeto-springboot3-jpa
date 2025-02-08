package com.gabrielprojeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielprojeto.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
