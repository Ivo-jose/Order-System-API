package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
