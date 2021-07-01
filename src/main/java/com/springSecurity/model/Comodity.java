package com.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Comodity {
	@Id
	private int c_id;
	private String c_name;
	private String sub_name;
	private String c_type;
	public Comodity(int c_id, String c_name, String sub_name, String c_type) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.sub_name = sub_name;
		this.c_type = c_type;
	}
	public Comodity() {
		super();
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	@Override
	public String toString() {
		return "Comodity [c_id=" + c_id + ", c_name=" + c_name + ", sub_name=" + sub_name + ", c_type=" + c_type + "]";
	}
	
}
