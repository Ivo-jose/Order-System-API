package com.ivogoncalves.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ivogoncalves.services.db.DBService;

@Configuration
public class TestConfig {

	@Autowired
	private DBService dbService;
	
	@Bean
	void instantiateDB() {
		dbService.instantitateDB();
	}
}
