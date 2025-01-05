package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

	Vendor findByUser(Users user);

	List<Vendor> findByBusinessNameContainingIgnoringCase(String businessName);

	Integer countByApproved(Boolean approved);

}
