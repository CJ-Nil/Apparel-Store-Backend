package com.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
	@Id
	private int b_id;
	private String b_name;
	private String cuntry_origin;
	public Brand(int b_id, String b_name, String cuntry_origin) {
		super();
		this.b_id = b_id;
		this.b_name = b_name;
		this.cuntry_origin = cuntry_origin;
	}
	public Brand() {
		super();
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getCuntry_origin() {
		return cuntry_origin;
	}
	public void setCuntry_origin(String cuntry_origin) {
		this.cuntry_origin = cuntry_origin;
	}
	@Override
	public String toString() {
		return "Brand [b_id=" + b_id + ", b_name=" + b_name + ", cuntry_origin=" + cuntry_origin + "]";
	}
	
}
