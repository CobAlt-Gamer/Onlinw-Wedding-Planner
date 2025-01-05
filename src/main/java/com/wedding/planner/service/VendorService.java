package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;

public interface VendorService {

	/**
	 * Adds Vendor to db
	 *
	 * @param vendor
	 * @return
	 */
	ResponseEntity<Vendor> addVendor(Users user, Vendor vendor);

	/**
	 * updates given Vendor
	 *
	 * @param vendor
	 * @return
	 */
	ResponseEntity<Vendor> updatevendor(Vendor vendor);

	/**
	 * gets All the vendors
	 *
	 * @return
	 */
	ResponseEntity<List<Vendor>> getVendors();

	/**
	 * deletes the given vendor
	 *
	 * @param vendor
	 * @return
	 */
	ResponseEntity<Boolean> deleteVendor(Vendor vendor);

	/**
	 * get vendor by Users
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<Vendor> getVendor(Users user);

	/**
	 * Gets Vendor By Id
	 * @param vendorId
	 * @return
	 */
	ResponseEntity<Vendor> getVendor(Integer vendorId);

	/**
	 * Searches for Vendor
	 * @param search
	 * @return
	 */
	ResponseEntity<List<Vendor>> getVendors(String search);

	/**
	 * Gets Approved vendors
	 * @return
	 */
	Integer getApprovedVendors();
}
