package com.wedding.planner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Address;
import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;

@Service
public class SignUpServiceImpl implements SignUpService {

	@Autowired
	private VendorService vendorService;

	@Override
	public ResponseEntity<Vendor> registerVendor(String firstName, String lastName, String email, String phone,
			String password, String business_nme, String business_contact, String gstNumber, Cities city,
			String addressLine1, String addressLine2) {
		try {
			Address address = Address.builder().city(city).addressLine1(addressLine1).addressLine2(addressLine2)
					.build();
			Users user = Users.builder().firstName(firstName).lastName(lastName).email(email).phone(phone)
					.password(password).address(List.of(address)).build();
			Vendor vendor = Vendor.builder().businessName(business_nme).businessContact(business_contact)
					.gstNumber(gstNumber).build();
			vendor = vendorService.addVendor(user, vendor).getBody();
			return ResponseEntity.ok(vendor);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
