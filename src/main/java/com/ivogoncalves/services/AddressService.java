package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Address;
import com.ivogoncalves.domains.dtos.AddressDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.AddressRepository;
import com.ivogoncalves.repositories.CustomerRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository repository;
	@Autowired
	private ModelMapper mapper;
	private Logger logger = Logger.getLogger(CustomerRepository.class.getName());
	
	
	public List<AddressDTO> findAll() {
		logger.info("Finds all address!");
		return repository.findAll().stream().map(x -> mapper.map(x, AddressDTO.class)).collect(Collectors.toList());
	}
	
	public AddressDTO findById(Long id) {
		logger.info("Find an address!");
		Address obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this Id! ID: " + id));
		return mapper.map(obj, AddressDTO.class);
	}
}
