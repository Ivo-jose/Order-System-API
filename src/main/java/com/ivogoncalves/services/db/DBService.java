package com.ivogoncalves.services.db;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Category;
import com.ivogoncalves.domains.City;
import com.ivogoncalves.domains.Product;
import com.ivogoncalves.domains.State;
import com.ivogoncalves.repositories.CategoryRepository;
import com.ivogoncalves.repositories.CityRepository;
import com.ivogoncalves.repositories.ProductRepository;
import com.ivogoncalves.repositories.StateRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	
	
	public void instantitateDB() {
		
		//Objects Category
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		//Objects Product
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		//Both relationship
		cat1.getProducts().addAll(Arrays.asList(p1,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		//Save in DB
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		//Objects State
		State st1 = new State(null, "Minas Gerais");
		State st2 = new State(null, "São Paulo");
		
		//Objects City
		City ct1 = new City(null, "Uberlândia", st1);
		City ct2 = new City(null, "São Paulo", st2);
		City ct3 = new City(null, "Campinas", st2);
		
		//Relationship
		st1.getCities().add(ct1);
		st2.getCities().add(ct2);
		st2.getCities().add(ct3);
		
		stateRepository.saveAll(Arrays.asList(st1,st2));
		cityRepository.saveAll(Arrays.asList(ct1,ct2,ct3));
	}
}
