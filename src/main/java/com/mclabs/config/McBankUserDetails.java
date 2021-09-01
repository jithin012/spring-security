package com.mclabs.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mclabs.model.Customer;
import com.mclabs.model.SecurityCustomer;
import com.mclabs.repository.CustomerRepository;

@Service
public class McBankUserDetails implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("I do not think I will call by spring...");
		List<Customer> customers = customerRepository.findByEmail(username);
		if (customers.size() == 0) {
			throw new UsernameNotFoundException("User details not found for the user " + username);
		}
		return new SecurityCustomer(customers.get(0));
	}
}
