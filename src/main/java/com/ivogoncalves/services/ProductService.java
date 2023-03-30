package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Product;
import com.ivogoncalves.domains.dtos.ProductDTO;
import com.ivogoncalves.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	private Logger logger = Logger.getLogger(ProductService.class.getName());
	
	public List<ProductDTO> findAll() {
		logger.info("Finds all Products!");
		List<Product> list = repository.findAll();
		List<ProductDTO> listDTO = list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		return listDTO;
	}
}
