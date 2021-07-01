package com.springSecurity.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.springSecurity.model.Product;
@Repository
public class ProductRepoCustomImpl implements ProductRepoCustom {

	@PersistenceContext
    EntityManager entityManager;
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findProductsByComodity(String comodity) {
		Query query = entityManager.createNativeQuery("SELECT p.p_code,p.p_name,p.b_id,p.c_id,p.m_date,p.price,p.cuntry_origin,p.type,p.style,p.offer,p.image_url FROM product p,comodity c WHERE p.c_id=c.c_id AND "
				+ "(c.c_name LIKE ? OR p.type LIKE ? ) ", Product.class);
        query.setParameter(1, "%" + comodity + "%");
        query.setParameter(2, "%" + comodity + "%");
        return query.getResultList();
	}
	@Override
	public List<Product> searchProducts(String keyword) {
		Query query = entityManager.createNativeQuery("SELECT p.p_code,p.p_name,p.b_id,p.c_id,p.m_date,p.price,p.cuntry_origin,p.type,p.style,p.offer,p.image_url "
				+ "FROM product p,comodity c,brand b WHERE p.c_id=c.c_id AND p.b_id=b.b_id AND "
				+ "(c.c_name LIKE ? OR p.type LIKE ? OR c.c_type LIKE ? OR b.b_name LIKE ? OR p.p_name LIKE ? OR p.p_code LIKE ? OR p.price LIKE ? ) ", Product.class);
        query.setParameter(1, "%" + keyword + "%");
        query.setParameter(2, "%" + keyword + "%");
        query.setParameter(3, "%" + keyword + "%");
        query.setParameter(4, "%" + keyword + "%");
        query.setParameter(5, "%" + keyword + "%");
        query.setParameter(6, "%" + keyword + "%");
        query.setParameter(7, "%" + keyword + "%");
        return query.getResultList();
	}
	@Override
	public List<Product> findProductsByComodityAndGender(String gen,int como[]) {
		String sql= "SELECT p.p_code,p.p_name,p.b_id,p.c_id,p.m_date,p.price,p.cuntry_origin,p.type,p.style,p.offer,p.image_url FROM product p,comodity c WHERE p.c_id=c.c_id AND c.c_type= ? AND c.c_id in ( ";
		for(int i=0;i<como.length-1;i++) {
			sql+=como[i]+",";
		}
		sql+=como[como.length-1]+")";
		Query query = entityManager.createNativeQuery(sql,Product.class);
        query.setParameter(1, gen);
        return query.getResultList();
	}
	@Override
	public List<Product> newArrivals() {
		Query query = entityManager.createNativeQuery("SELECT * FROM product where m_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH) ", Product.class);
        
        return query.getResultList();
	}
	

}
