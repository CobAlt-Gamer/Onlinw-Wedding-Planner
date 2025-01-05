package com.wedding.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
