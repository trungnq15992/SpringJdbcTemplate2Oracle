package com.trung;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcTemplate2OracleApplication implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplate2OracleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//use Spring JDBC
		String sql = "SELECT * FROM customer";
		List<Customer> ls = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Customer.class));
		
		for (Customer customer : ls) {
			System.out.println("Name: " + customer.getName() + " - " + "Age: " + customer.getAge());
		}
		
		//use Spring Data JPA
		List<Customer> ls2 = customerRepository.findAll();
		ls2.forEach(System.out::println);
	}
}
