package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
			     produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
			    )
	public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO objDTO) {
		CategoryDTO obj = service.create(objDTO);
		return ResponseEntity.ok().body(obj);
	}
	
	@PutMapping(value = "/{id}" , consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML},
		     produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML}
		    )
	public ResponseEntity<CategoryDTO> update(@PathVariable(value = "id") Long id, @RequestBody CategoryDTO objDTO) {
		CategoryDTO obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

//https://github.com/Ivo-jose/helpdesk-api/blob/main/src/main/java/com/ivogoncalves/helpdesk/resources/ClienteResource.java