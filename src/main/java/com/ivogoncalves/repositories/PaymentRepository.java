package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	
}
