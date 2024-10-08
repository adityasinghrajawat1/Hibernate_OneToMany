package com.springboot.mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.mapping.model.Address;
import com.springboot.mapping.repository.AddressRepository;


@Service
public class AddressService {

	
	 @Autowired
     AddressRepository addressRepo;
     
     public List<Address> getAllAddress()
     {
   	   return addressRepo.findAll();
     }
     
     public Address UpdateAddress(Address address, Long id)
     {
   	  Optional<Address> optionalAddress = addressRepo.findById(id);
   	  
   	  if(optionalAddress.isPresent())
   	  {
   		  Address address2 = optionalAddress.get();
   		  
   		  address2.setStreet(address.getStreet());
   		  address2.setCity(address.getCity());
   		  address2.setState(address.getState());
   		  
   		  return addressRepo.save(address2);
   	  }
   	  
   	  throw new IllegalArgumentException("Address not Found with id: "+id);
     }
}
