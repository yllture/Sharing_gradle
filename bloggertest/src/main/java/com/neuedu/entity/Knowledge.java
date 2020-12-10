package com.neuedu.entity;

public class Knowledge {
	private String name;
	private Integer number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Knowledge(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
	}

}
