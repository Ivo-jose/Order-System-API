package com.ivogoncalves.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ivogoncalves.domains.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.name =:name")
	Category findByCategoryName(@Param("name") String name);
}
