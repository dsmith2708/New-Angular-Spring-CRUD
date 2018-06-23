package com.qa.angularspringcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class CustomerAccountService implements AccountService{
	
	@Autowired
	private CustomerAccountRepository repository;
	
	@Override
	public String returnAllCustomerAccounts() {
		return new Gson().toJson(repository.findAll());
	}

	@Override
	public String addAccount(String newAccountJson) {
		repository.save(new Gson().fromJson(newAccountJson, CustomerAccount.class));
    	return "{\"message\" : \"Create successful\"}";
	}

	@Override
	public String deleteAccount(long accountToDeleteID) {
		repository.deleteById(accountToDeleteID);
    	return "{\"message\" : \"Delete successful\"}";
	}

	@Override
	public String updateAccount(String updatedAccountJson) {
		CustomerAccount customerFromJson = new Gson().fromJson(updatedAccountJson, CustomerAccount.class);
    	CustomerAccount customerFromDB = repository.findById(customerFromJson.getId()).get();
    	customerFromDB.setAccountNo(customerFromJson.getAccountNo());
    	customerFromDB.setFirstName(customerFromJson.getFirstName());
    	customerFromDB.setLastName(customerFromJson.getLastName());
    	repository.save(customerFromDB);
    	return "{\"message\" : \"Update successful\"}";
	}

}
