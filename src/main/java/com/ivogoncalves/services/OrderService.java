package com.ivogoncalves.services;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.CardPayment;
import com.ivogoncalves.domains.Order;
import com.ivogoncalves.domains.PaymentWithBankSlip;
import com.ivogoncalves.domains.dtos.OrderDTO;
import com.ivogoncalves.exceptions.ResourceNotFoundException;
import com.ivogoncalves.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	private Logger logger = Logger.getLogger(OrderService.class.getName());
	
	
	public List<OrderDTO> findAll() {
		logger.info("Finds all cities!");
		List<Order> list = repository.findAll();
		for(Order x : list) {
			if(x.getPayment() instanceof CardPayment) {
				x.setPayment((CardPayment) x.getPayment());
			}
			else {
				x.setPayment((PaymentWithBankSlip) x.getPayment());
			}
		}
		return list.stream().map(x -> mapper.map(x, OrderDTO.class)).collect(Collectors.toList());
	}
	
	public OrderDTO findById(Long id) {
		logger.info("Find one city!");
		Order obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("There are no records for this id! ID: " + id));
		return mapper.map(obj, OrderDTO.class);
	}
}
