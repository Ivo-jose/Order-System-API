package com.ivogoncalves.services.db;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Category;
import com.ivogoncalves.domains.Product;
import com.ivogoncalves.repositories.CategoryRepository;
import com.ivogoncalves.repositories.ProductRepository;

@Service
public class DBService {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	public void instantitateDB() {
		
		//Objects Category
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");
		
		//Objects Product
		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p3));
		cat2.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1));
		p2.getCategories().addAll(Arrays.asList(cat1,cat2));
		p3.getCategories().addAll(Arrays.asList(cat1));
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
}
