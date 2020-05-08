package com.sapo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONFIG")
public class Config {
	@Id
	@Column(name = "NAME")
	private String name;
	@Column(name = "VALUE", columnDefinition = "integer default 0")
	private Integer value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Config() {
		super();
	}
	
	public Config(String name, Integer value) {
		super();
		this.name = name;
		this.value = value;
	}
	
}
