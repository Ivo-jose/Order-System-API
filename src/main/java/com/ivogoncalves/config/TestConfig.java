package com.ivogoncalves.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ivogoncalves.services.DBService;

@Configuration
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	public void instantiateDB() {
		dbService.instantitateDB();
	}
}