package com.ivogoncalves.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivogoncalves.domains.dtos.CustomerDTO;
import com.ivogoncalves.services.CustomerService;
import com.ivogoncalves.util.MediaType;

@RestController
@RequestMapping(value = "/api/customer/v1")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<CustomerDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}" ,produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML})
	public ResponseEntity<CustomerDTO> findById(@PathVariable(value = "id") Long id) {
		CustomerDTO  objDTO = service.findById(id);
		return ResponseEntity.ok().body(objDTO);
	}
}
