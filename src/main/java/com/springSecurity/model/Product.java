package com.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int p_code;
	private int c_id;
	private int b_id;
	private String p_name;
	private String m_date;
	private String cuntry_origin;
	private String type;
	private String style;
	private double price;
	private String image_url;
	private int offer;
	public Product(int p_code,int c_id, int b_id, String p_name, String m_date, String cuntry_origin, String type,
			String style, double price, int offer) {
		super();
		this.p_code = p_code;
		this.c_id = c_id;
		this.b_id = b_id;
		this.p_name = p_name;
		this.m_date = m_date;
		this.cuntry_origin = cuntry_origin;
		this.type = type;
		this.style = style;
		this.price = price;
		this.offer = offer;
	}
	public int getP_code() {
		return p_code;
	}
	public void setP_code(int p_code) {
		this.p_code = p_code;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getCuntry_origin() {
		return cuntry_origin;
	}
	public void setCuntry_origin(String cuntry_origin) {
		this.cuntry_origin = cuntry_origin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getOffer() {
		return offer;
	}
	
	public void setOffer(int offer) {
		this.offer = offer;
	}
	
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [p_code=" + p_code + ", c_id=" + c_id + ", b_id=" + b_id + ", p_name=" + p_name + ", m_date="
				+ m_date + ", cuntry_origin=" + cuntry_origin + ", type=" + type + ", style=" + style + ", price="
				+ price + ", image_url=" + image_url + ", offer=" + offer + "]";
	}
	
}
