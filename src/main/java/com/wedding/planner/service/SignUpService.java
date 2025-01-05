package com.wedding.planner.service;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.Vendor;

public interface SignUpService {

	ResponseEntity<Vendor> registerVendor(String firstName, String lastName, String email, String phone,
			String password, String business_nme, String business_contact, String gstNumber,Cities city,String addressLine1,String addressLine2);

}
