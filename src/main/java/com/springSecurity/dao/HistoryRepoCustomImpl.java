package com.springSecurity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springSecurity.model.History;

@Repository
public class HistoryRepoCustomImpl implements HistoryRepoCustom {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<History> findAllHistoryByUsername(String username) {
		Query query = entityManager.createNativeQuery("Select h.username,h.c_id,h.offer,h.date from history h where h.username=? order by h.date DESC limit 4", History.class);
		query.setParameter(1,username);
		return query.getResultList();
	}
	
}
