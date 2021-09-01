package com.mclabs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mclabs.model.AccountTransactions;
import com.mclabs.model.Customer;
import com.mclabs.repository.AccountTransactionsRepository;

@RestController
public class BalanceController {

	@Autowired
	private AccountTransactionsRepository accountTransactionRepository;

	@PostMapping
	public List<AccountTransactions> getBalanceDetails(@RequestBody Customer customer) {
		List<AccountTransactions> accountTransactions = accountTransactionRepository
				.findByCustomerIdOrderByTransactionDtDesc(customer.getId());
		if (accountTransactions != null) {
			return accountTransactions;
		} else {
			return null;
		}
	}

	@GetMapping("/myBalance")
	public String getBalanceDetails(String input) {
		return "Here are the balance details";
	}
}
