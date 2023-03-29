package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Category;
import com.ivogoncalves.domains.dtos.CategoryDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	private Logger logger = Logger.getLogger(CategoryService.class.getName());
	
	public List<CategoryDTO> findAll() { 
		logger.info("Finds all Categories!");
		List<Category> objList = repository.findAll();
		List<CategoryDTO> objListDTO = objList.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		return objListDTO;		
	}
	
	public CategoryDTO findById(Long id) {
		logger.info("Finding one Category!");
		Category obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id! ID: " + id));
		return new CategoryDTO(obj);
	}
}
