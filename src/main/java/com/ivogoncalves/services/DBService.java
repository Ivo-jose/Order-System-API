package com.ivogoncalves.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Category;
import com.ivogoncalves.repositories.CategoryRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public void instantitateDB() {
		
		Category cat1 = new Category(1L, "Informática");
		Category cat2 = new Category(2L, "Escritório");
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
	}
}
