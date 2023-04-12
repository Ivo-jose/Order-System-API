package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.AddressDTO;
import com.ivogoncalves.services.AddressService;
import com.ivogoncalves.util.MediaType;

@RestController
@RequestMapping(value = "/api/address/v1")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<AddressDTO>> findAll() {
		List<AddressDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<AddressDTO> findById(@PathVariable(value = "id") Long id) {
		AddressDTO  objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}
