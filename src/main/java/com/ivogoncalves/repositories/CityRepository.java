package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.City;

public interface CityRepository extends JpaRepository<City, Long> {}
