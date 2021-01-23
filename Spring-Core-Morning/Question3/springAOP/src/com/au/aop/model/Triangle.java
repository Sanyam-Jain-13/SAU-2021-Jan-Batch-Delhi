package com.au.aop.model;

public class Triangle {
	
	private String name;

	public String getName() throws Exception{
		if(this.name == "")
			throw new NullPointerException();
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
