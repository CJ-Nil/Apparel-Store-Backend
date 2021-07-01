package com.springSecurity.models;

import java.util.Arrays;

public class RequestParameter {
	private String gen;
	private int como[];
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int[] getComo() {
		return como;
	}
	public void setComo(int[] como) {
		this.como = como;
	}
	public RequestParameter(String gen, int[] como) {
		super();
		this.gen = gen;
		this.como = como;
	}
	@Override
	public String toString() {
		return "RequestParams [gen=" + gen + ", como=" + Arrays.toString(como) + "]";
	}
	
}
