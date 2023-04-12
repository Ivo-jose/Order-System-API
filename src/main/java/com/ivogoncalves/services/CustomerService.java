package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Customer;
import com.ivogoncalves.domains.dtos.CustomerDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private ModelMapper mapper;
	private Logger logger = Logger.getLogger(CustomerRepository.class.getName());
	
	
	public List<CustomerDTO> findAll() {
		logger.info("Finds all customers!");
		return repository.findAll().stream().map(x -> mapper.map(x, CustomerDTO.class)).collect(Collectors.toList());
	}
	
	public CustomerDTO findById(Long id) {
		logger.info("Find a customer!");
		Customer obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this Id! ID: " + id));
		return mapper.map(obj, CustomerDTO.class);
	}
}
