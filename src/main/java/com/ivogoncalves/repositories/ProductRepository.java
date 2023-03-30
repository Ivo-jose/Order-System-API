package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}