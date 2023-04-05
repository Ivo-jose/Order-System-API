package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.City;
import com.ivogoncalves.domains.dtos.CityDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	private Logger logger = Logger.getLogger(CityService.class.getName());
	
	
	public List<CityDTO> findAll() {
		logger.info("Finds all cities!");
		return repository.findAll().stream().map(x -> mapper.map(x, CityDTO.class)).collect(Collectors.toList());
	}
	
	public CityDTO findById(Long id) {
		logger.info("Find one city!");
		City obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this id! ID: " + id));
		return mapper.map(obj, CityDTO.class);
	}
}
