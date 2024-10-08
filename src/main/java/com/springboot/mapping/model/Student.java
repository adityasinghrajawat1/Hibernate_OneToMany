package com.springboot.mapping.model;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Address> address;

	
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
	{
		this.id = id;
	}

	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public List<Address> getAddress() 
	{
		return address;
	}
	public void setAddress(List<Address> address) 
	{
		this.address = address;
		
        if (address != null) 
        {
            for (Address addr : address) 
            {
                addr.setStudent(this); // Ensure each address knows its student
            }
        }
	}

	
}
