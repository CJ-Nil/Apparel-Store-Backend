package com.springSecurity.dao;

import java.util.List;

import com.springSecurity.model.Order;

public interface OrderRepoCustom {
	List<Order> findAllById(String id);
}
