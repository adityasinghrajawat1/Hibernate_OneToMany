package com.springboot.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.mapping.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
