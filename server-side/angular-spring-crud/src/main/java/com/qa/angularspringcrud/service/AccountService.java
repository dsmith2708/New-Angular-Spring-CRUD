package com.qa.angularspringcrud.service;

public interface AccountService {
	String returnAllCustomerAccounts();
	String addAccount(String newAccountJson);
	String deleteAccount(long accountToDeleteID);
	String updateAccount(String updatedAccountJson);
}
