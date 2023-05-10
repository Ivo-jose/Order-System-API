package com.ivogoncalves.services.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivogoncalves.domains.Address;
import com.ivogoncalves.domains.CardPayment;
import com.ivogoncalves.domains.Category;
import com.ivogoncalves.domains.City;
import com.ivogoncalves.domains.Customer;
import com.ivogoncalves.domains.Order;
import com.ivogoncalves.domains.Payment;
import com.ivogoncalves.domains.PaymentWithBankSlip;
import com.ivogoncalves.domains.Product;
import com.ivogoncalves.domains.State;
import com.ivogoncalves.domains.enums.CustomerType;
import com.ivogoncalves.domains.enums.PaymentStatus;
import com.ivogoncalves.repositories.AddressRepository;
import com.ivogoncalves.repositories.CategoryRepository;
import com.ivogoncalves.repositories.CityRepository;
import com.ivogoncalves.repositories.CustomerRepository;
import com.ivogoncalves.repositories.OrderRepository;
import com.ivogoncalves.repositories.PaymentRepository;
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
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
//	@Autowired
//	private CardPaymentRepository cardPaymentRepository;
//	@Autowired
//	private PaymentWithBankSlipRepository paymentWithBankSlipRepository;
	
	
	public void instantitateDB() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
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
		
		//Objects Customer
		Customer cus1 = new Customer(null, "Maria Silva", "maria@gmail.com", "834.001.458-74", CustomerType.NATURAL_PERSON);
		
		//Add phones
		cus1.getPhones().add("27363323");
		cus1.getPhones().add("93838393");
		
		//Objects address
		Address add1 = new Address(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220384", cus1,ct1);
		Address add2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cus1,ct2);
		
		
		//Relationship
		cus1.getAddress().addAll(Arrays.asList(add1,add2));
		
		customerRepository.saveAll(Arrays.asList(cus1));
		addressRepository.saveAll(Arrays.asList(add1,add2));
		
		Order ord1 = new Order(null, sdf.parse("30/09/2017 10:32"), cus1, add1,null);
		Order ord2 = new Order(null, sdf.parse("10/10/2017 19:35"), cus1, add2,null);
		cus1.getOrders().addAll(Arrays.asList(ord1, ord2));
		Payment pay1 = new CardPayment(null, PaymentStatus.PAID, ord1 , 6);
		
		ord1.setPayment(pay1);
		Payment pay2 = new PaymentWithBankSlip(null, PaymentStatus.PENDING, ord2, sdf.parse("20/10/2017 00:00"), null);
		ord2.setPayment(pay2);
		orderRepository.saveAll(Arrays.asList(ord1,ord2));
		paymentRepository.saveAll(Arrays.asList(pay1,pay2));
		
		
	}
}
