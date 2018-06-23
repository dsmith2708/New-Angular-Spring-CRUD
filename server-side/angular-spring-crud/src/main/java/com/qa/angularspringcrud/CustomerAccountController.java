package com.qa.angularspringcrud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class CustomerAccountController {
	@Autowired
	private AccountService accountService;
	
	public CustomerAccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping("/all-customers")
    @CrossOrigin(origins = "http://localhost:4200")
    public String allCustomers() {
        return accountService.returnAllCustomerAccounts();
    }
	
	@PostMapping("/add-customer")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String createCustomer(@RequestBody String customerJson){
    	return accountService.addAccount(customerJson);
    }
	
	@PutMapping("/update-customer")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String updateCustomer(@RequestBody String customerJson) {
    	return accountService.updateAccount(customerJson);
    }
	
	@DeleteMapping(value="/delete-customer/{accountID}")
	@CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public String returnRequestBody(@PathVariable long accountID){
    	return accountService.deleteAccount(accountID);
    }
}
