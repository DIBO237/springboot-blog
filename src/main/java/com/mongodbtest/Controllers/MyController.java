package com.mongodbtest.Controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodbtest.Repository.CustomerRepository;
import com.mongodbtest.Models.Customer;


@Controller
class MyController {
	
	
	 @Autowired
	 private CustomerRepository userRepository;
	 
	 
	 @PostMapping("/post")
	 @ResponseBody
	 public Customer postHandle(@RequestBody Customer user) {
	 	 
		 Customer n = new Customer("hello","jdddd");
		      
		    userRepository.save(user);
	 	 
		    
	 	return user;

	 }
	 
	 @GetMapping("/getall")
	 @ResponseBody
	 public List<Customer> getAllCustomers() {
		    // Retrieve all customers from the repository and store them in a variable
		    List<Customer> customers = userRepository.findAll();

		    // You can now use the 'customers' variable as needed in your code
		    return customers;
		}
	 
	 
}

