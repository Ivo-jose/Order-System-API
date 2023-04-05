package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.CityDTO;
import com.ivogoncalves.services.CityService;
import com.ivogoncalves.util.MediaType;

@RestController
@RequestMapping(value = "/api/city/v1")
public class CityController {

	@Autowired
	private CityService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<CityDTO>> findAll() {
		List<CityDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<CityDTO> findByID(@PathVariable Long id) {
		CityDTO objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}
