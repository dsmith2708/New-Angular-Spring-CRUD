package com.qa.angularspringcrud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource 
@CrossOrigin(origins = "http://localhost:4200")
public
interface CustomerAccountRepository extends JpaRepository<CustomerAccount, Long> {
	
}