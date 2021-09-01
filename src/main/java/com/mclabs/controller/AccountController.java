package com.mclabs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mclabs.model.Accounts;
import com.mclabs.model.Customer;
import com.mclabs.repository.AccountsRepository;

@RestController
public class AccountController {
	@Autowired
	private AccountsRepository accountRepository;

	@GetMapping("/myAccount")
	public String getAccountDetails(String input) {
		return "Here are the account details";
	}

	@PostMapping("/myAccount")
	public Accounts getAccountDetails(@RequestBody Customer customer) {
		Accounts account = accountRepository.findByCustomerId(customer.getId());
		if (account != null) {
			return account;
		} else {
			return null;
		}
	}
}
