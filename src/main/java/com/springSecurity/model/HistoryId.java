package com.springSecurity.model;

import java.io.Serializable;

public class HistoryId implements Serializable {
  
	private static final long serialVersionUID = 1L;

	private String username;

    private int c_id;

	public HistoryId(String username, int c_id) {
		super();
		this.username = username;
		this.c_id = c_id;
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

	public HistoryId() {
		super();
	}

    // default constructor

    

    // equals() and hashCode()
}
