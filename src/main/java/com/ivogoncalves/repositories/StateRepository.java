package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ivogoncalves.domains.State;

public interface StateRepository extends JpaRepository<State, Long> {}
