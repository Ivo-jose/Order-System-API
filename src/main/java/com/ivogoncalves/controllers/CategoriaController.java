package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.CategoryDTO;
import com.ivogoncalves.services.CategoryService;
import com.ivogoncalves.util.MediaType;


@RestController
@RequestMapping(value = "/api/category/v1")
public class CategoriaController {

	@Autowired
	private CategoryService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<CategoryDTO> findById(@PathVariable(value = "id") Long id){
		CategoryDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}