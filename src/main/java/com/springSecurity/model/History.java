package com.springSecurity.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(HistoryId.class)
@Entity
public class History {
	@Id
	private  String username;
	@Id
	private int c_id;
	
	private int offer;
	private String date;
	public History(String username, int c_id, int offer, String date) {
		super();
		this.username = username;
		this.c_id = c_id;
		this.offer = offer;
		this.date = date;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public History() {
		super();
	}
	public History(String username, int c_id, int offer) {
		super();
		this.username = username;
		this.c_id = c_id;
		this.offer = offer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}
	@Override
	public String toString() {
		return "History [username=" + username + ", c_id=" + c_id + ", offer=" + offer + ", date=" + date + "]";
	}
	
	
}
