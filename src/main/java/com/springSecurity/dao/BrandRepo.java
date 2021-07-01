package com.springSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Brand;

public interface BrandRepo extends JpaRepository<Brand,Integer> {

}
