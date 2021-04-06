package com.qltb.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String name;
	private String descrition;
	@ManyToOne
	@JoinColumn(name= "employee_id")
	@JsonIgnore
	private Employee employee;

	
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Device(Long id, String code, String name, String descrition, Employee employee) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.descrition = descrition;
		this.employee = employee;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescrition() {
		return descrition;
	}


	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	
	
}
