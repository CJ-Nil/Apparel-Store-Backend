package com.springSecurity.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.model.Order;

public interface OrderRepo extends JpaRepository<Order,Integer>,OrderRepoCustom {

}
