package com.springboot.mapping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Address {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String Street;
	private String City;
	private String State;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "student_id",referencedColumnName = "id")
	 @JsonIgnore
	private Student student;

	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}

	
	public String getStreet() 
	{
		return Street;
	}
	public void setStreet(String street) 
	{
		Street = street;
	}

	
	public String getCity() 
	{
		return City;
	}
	public void setCity(String city) 
	{
		City = city;
	}

	
	public String getState() 
	{
		return State;
	}
	public void setState(String state) 
	{
		State = state;
	}

	
	public Student getStudent() 
	{
		return student;
	}
	public void setStudent(Student student) 
	{
		this.student = student;
	}	
}
