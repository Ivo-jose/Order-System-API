package com.ivogoncalves.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/category/v1")
public class CategoriaController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String listar() {
		return "REST is working";
	}
}
