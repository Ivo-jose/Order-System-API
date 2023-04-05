package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.StateDTO;
import com.ivogoncalves.services.StateService;
import com.ivogoncalves.util.MediaType;

@RestController
@RequestMapping(value = "/api/state/v1")
public class StateController {

	@Autowired
	private StateService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<StateDTO>> findAll() {
		List<StateDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<StateDTO> findByID(@PathVariable Long id) {
		StateDTO objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}
