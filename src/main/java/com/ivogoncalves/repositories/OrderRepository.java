package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
