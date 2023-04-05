package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Product;
import com.ivogoncalves.domains.dtos.ProductDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private ModelMapper mapper;
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	public List<ProductDTO> findAll() {
		logger.info("Finds all Products!");
		return repository.findAll().stream().map(x -> mapper.map(x, ProductDTO.class)).collect(Collectors.toList());
	}
	
	public ProductDTO findById(Long id) {
		logger.info("Find  one Product!");
		Product obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this id! ID: " + id));
		return mapper.map(obj, ProductDTO.class);
	}
}
