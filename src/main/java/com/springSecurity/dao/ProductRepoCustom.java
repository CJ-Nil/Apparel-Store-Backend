package com.springSecurity.dao;

import java.util.List;

import com.springSecurity.model.Product;

public interface ProductRepoCustom {
	List<Product> findProductsByComodity(String comodity);
	List<Product> findProductsByComodityAndGender(String gen,int como[]);
	List<Product> searchProducts(String keyword);
	List<Product> newArrivals();
}
