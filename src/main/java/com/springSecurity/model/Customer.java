package com.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private String username;
	private String name;
	private String address;
	private String phone;
	private String gender;
	public Customer() {
		super();
	}
	public Customer(String username, String name, String address, String phone, String gender) {
		super();
		this.username = username;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", gender=" + gender + "]";
	}
	
	
}
