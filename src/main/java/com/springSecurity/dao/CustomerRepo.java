package com.springSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer,String> {
	
}
