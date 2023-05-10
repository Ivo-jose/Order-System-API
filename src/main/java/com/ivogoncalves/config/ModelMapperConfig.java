package com.ivogoncalves.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

	@Bean
	ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
//		TypeMap<Payment, PaymentDTO> typeMap = modelMapper.createTypeMap(Payment.class, PaymentDTO.class)
//				.addMapping(Payment::getId, PaymentDTO::setId)
//				.addMapping(Payment::getPaymentStatus, PaymentDTO::setPaymentStatus)
//				.addMapping(Payment::getOrder, PaymentDTO::setOrder);
//
//			typeMap.include(CardPayment.class, CardPaymentDTO.class)
//				   .include(PaymentWithBankSlip.class, PaymentWithBankSlipDTO.class);
//		return  (ModelMapper) typeMap;
		
		return modelMapper;
	}
}
