package com.qa.angularspringcrud.service;

import com.qa.angularspringcrud.domain.CustomerAccount;
import com.google.gson.Gson;
import com.qa.angularspringcrud.repository.CustomerAccountRepository;

public class CustomerAccountService implements AccountService{
	
	private CustomerAccountRepository repository;
	
	@Override
	public String returnAllCustomerAccounts() {
		return new Gson().toJson(repository.findAll());
	}

	@Override
	public String addAccount(String newAccountJson) {
		repository.save(new Gson().fromJson(newAccountJson, CustomerAccount.class));
    	return "\"message\" : \"Create successful\"";
	}

	@Override
	public String deleteAccount(long accountToDeleteID) {
		repository.deleteById(accountToDeleteID);
    	return "\"message\" : \"Delete successful\"";
	}

	@Override
	public String updateAccount(String updatedAccountJson) {
		CustomerAccount customerFromJson = new Gson().fromJson(updatedAccountJson, CustomerAccount.class);
    	CustomerAccount customerFromDB = repository.findById(customerFromJson.getId()).get();
    	customerFromDB.setAccountNo(customerFromJson.getAccountNo());
    	customerFromDB.setFirstName(customerFromJson.getFirstName());
    	customerFromDB.setLastName(customerFromJson.getLastName());
    	repository.save(customerFromDB);
    	return "\"message\" : \"Update successful\"";
	}

}
