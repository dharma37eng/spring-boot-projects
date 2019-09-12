package com.student.ldap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class StudentDetails {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Double percentage;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", name=" + name + ", percentage=" + percentage + "]";
	}
}
