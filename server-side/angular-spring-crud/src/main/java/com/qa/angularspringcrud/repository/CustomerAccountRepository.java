package com.qa.angularspringcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.qa.angularspringcrud.domain.CustomerAccount;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
	
}