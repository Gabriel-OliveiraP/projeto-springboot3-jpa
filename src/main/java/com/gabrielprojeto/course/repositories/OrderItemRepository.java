package com.gabrielprojeto.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielprojeto.course.entities.OrderItem;
import com.gabrielprojeto.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
	/*
	 * Não precisamos colocar os métodos, pq o SpringDataJpa já tem
	 * a implementação padrão para isso.
	 */
}
