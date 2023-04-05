package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.ProductDTO;
import com.ivogoncalves.services.ProductService;
import com.ivogoncalves.util.MediaType;

@RestController
@RequestMapping(value = "/api/product/v1")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<ProductDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<ProductDTO> findByID(@PathVariable Long id) {
		ProductDTO objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}
