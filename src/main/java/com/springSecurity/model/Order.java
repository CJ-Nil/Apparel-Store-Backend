package com.springSecurity.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	private int id;
	private int p_id;
	private String cust_id;
	private int price;
	private int quantity;
	private String o_date;
	public Order(int id, int p_id, String cust_id, int price, int quantity, String o_date) {
		super();
		this.id = id;
		this.p_id = p_id;
		this.cust_id = cust_id;
		this.price = price;
		this.quantity = quantity;
		this.o_date = o_date;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	public Order(int p_id, String cust_id, int price, int quantity, String o_date) {
		super();
		this.p_id = p_id;
		this.cust_id = cust_id;
		this.price = price;
		this.quantity = quantity;
		this.o_date = o_date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", p_id=" + p_id + ", cust_id=" + cust_id + ", price=" + price + ", quantity="
				+ quantity + ", o_date=" + o_date + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order() {
		super();
	}
	
}
