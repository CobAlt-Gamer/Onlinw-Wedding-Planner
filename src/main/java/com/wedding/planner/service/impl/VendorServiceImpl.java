package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;
import com.wedding.planner.enums.UserRole;
import com.wedding.planner.repository.VendorRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private UserService userService;

	@Override
	@CachePut("vendors")
	public ResponseEntity<Vendor> addVendor(Users user, Vendor vendor) {
		try {
			user.setRole(UserRole.VENDOR);
			vendor.setUser(userService.addUser(user).getBody());
			vendor.setAcceptOrders(false);
			vendor.setApproved(false);
			return ResponseEntity.ok(vendorRepo.save(vendor));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	@CachePut("vendors")
	public ResponseEntity<Vendor> updatevendor(Vendor vendor) {
		Optional<Vendor> dbVendorOpt = vendorRepo.findById(vendor.getVendorId());

		if (dbVendorOpt.isPresent()) {

//			user
			if (Objects.nonNull(vendor.getUser())) {
				dbVendorOpt.ifPresent(data -> data.setUser(userService.updateUser(vendor.getUser()).getBody()));
			}

//			accept orders
			if (Objects.nonNull(vendor.getAcceptOrders())) {
				dbVendorOpt.ifPresent(data -> data.setAcceptOrders(vendor.getAcceptOrders()));
			}

//			approved
			if (Objects.nonNull(vendor.getApproved())) {
				dbVendorOpt.ifPresent(data -> data.setApproved(vendor.getApproved()));
			}

//			business name
			if (Objects.nonNull(vendor.getBusinessName()) && !"".equalsIgnoreCase(vendor.getBusinessName())) {
				dbVendorOpt.ifPresent(data -> data.setBusinessName(vendor.getBusinessName()));
			}

//			business contact
			if (Objects.nonNull(vendor.getBusinessContact()) && !"".equalsIgnoreCase(vendor.getBusinessContact())) {
				dbVendorOpt.ifPresent(data -> data.setBusinessContact(vendor.getBusinessContact()));
			}

			return ResponseEntity.ok(vendorRepo.save(dbVendorOpt.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@Cacheable(value = "vendors")
	public ResponseEntity<List<Vendor>> getVendors() {
		return ResponseEntity.ok(vendorRepo.findAll());
	}

	@Override
	@CacheEvict(value = "vendors", key = "#vendor.vendorId")
	public ResponseEntity<Boolean> deleteVendor(Vendor vendor) {
		Optional<Vendor> dbVendor = vendorRepo.findById(vendor.getVendorId());
		if (dbVendor.isPresent()) {
			vendorRepo.delete(dbVendor.get());
			return ResponseEntity.ok(true);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	@Cacheable(value = "vendors")
	public ResponseEntity<Vendor> getVendor(Users user) {
		return ResponseEntity.ok(vendorRepo.findByUser(user));
	}

	@Override
	@Cacheable(value = "vendors", key = "#vendorId")
	public ResponseEntity<Vendor> getVendor(Integer vendorid) {
		return ResponseEntity.ok(vendorRepo.findById(vendorid).get());
	}

	@Override
	public ResponseEntity<List<Vendor>> getVendors(String search) {
		return ResponseEntity.ok(vendorRepo.findByBusinessNameContainingIgnoringCase(search));
	}

	@Override
	public Integer getApprovedVendors() {
		return vendorRepo.countByApproved(true);
	}

}
