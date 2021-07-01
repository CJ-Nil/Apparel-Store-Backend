package com.springSecurity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.springSecurity.model.Order;


public class OrderRepoCustomImpl implements OrderRepoCustom {
	@PersistenceContext
    EntityManager entityManager;
	@Override
	public List<Order> findAllById(String id) {
		Query query = entityManager.createNativeQuery("SELECT * FROM order where cust_id=? ", Order.class);
		query.setParameter(1, id);
        return query.getResultList();
	}
	
}
