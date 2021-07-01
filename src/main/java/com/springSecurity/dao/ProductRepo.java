package com.springSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Product; 

public interface ProductRepo extends JpaRepository<Product,Integer>,ProductRepoCustom {

}
