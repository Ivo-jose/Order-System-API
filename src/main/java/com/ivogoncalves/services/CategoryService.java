package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper mapper;
	
	private Logger logger = Logger.getLogger(CategoryService.class.getName());
	
	public List<CategoryDTO> findAll() { 
		logger.info("Finds all Categories!");
		return repository.findAll().stream().map(x -> mapper.map(x, CategoryDTO.class)).collect(Collectors.toList());
	}
	
	public CategoryDTO findById(Long id) {
		logger.info("Finding one Category!");
		Category obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this id! ID: " + id));
		return mapper.map(obj, CategoryDTO.class);
	}
}
