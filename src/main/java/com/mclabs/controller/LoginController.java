package com.mclabs.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mclabs.model.Customer;
import com.mclabs.repository.CustomerRepository;

@RestController
public class LoginController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping("/user")
	public Customer getUserDetailsAfterLogin(Principal user) {
		List<Customer> customer = customerRepository.findByEmail(user.getName());
		if (customer.size() > 0) {
			return customer.get(0);
		} else {
			return null;
		}
	}
}
