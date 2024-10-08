package com.springboot.mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mapping.model.Address;
import com.springboot.mapping.service.AddressService;



@RestController
public class AddressController {

	@Autowired
	AddressService addressService;
	
   @GetMapping("run")
   public String running()
   {
	   return "running...";
   }
   

	@GetMapping("/address/getAll")
	public List<Address> getAllAddress()
	{
		return addressService.getAllAddress();
	}
	
	@PutMapping("/address/update/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable Long id)
	{
		return addressService.UpdateAddress(address, id);
	}
   
}
