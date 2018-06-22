package com.qa.angularspringcrud.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;



@Entity
public class CustomerAccount {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(min = 2, max = 80)
	private String firstName;
	@Size(min = 2, max = 80)
	private String lastName;
	@Size(min = 4, max = 4)
	private String accountNo;
	public String getFirstName() {
		return firstName;
	}
	
	public CustomerAccount() {
		
	}
	
	public CustomerAccount(long id, String firstName, String lastName, String accountNo) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNo = accountNo;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public long getId() {
		return id;
	}
	
	
}
