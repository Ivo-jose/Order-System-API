package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.State;
import com.ivogoncalves.domains.dtos.StateDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	private Logger logger = Logger.getLogger(StateService.class.getName());
	
	public List<StateDTO> findAll() {
		logger.info("Finds all states !");
		return repository.findAll().stream().map(x -> mapper.map(x, StateDTO.class)).collect(Collectors.toList());
	}
	
	public StateDTO findById(Long id) {
		logger.info("Find one state!");
		State obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this id! ID: " + id));
		return mapper.map(obj, StateDTO.class);
	}
}
