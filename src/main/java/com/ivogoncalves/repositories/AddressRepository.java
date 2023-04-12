package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {}
