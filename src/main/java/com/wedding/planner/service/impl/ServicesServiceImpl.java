package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Users;
import com.wedding.planner.enums.UserRole;
import com.wedding.planner.repository.ServicesRepository;
import com.wedding.planner.service.ServicesService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.service.VendorService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ServicesServiceImpl implements ServicesService {

	@Autowired
	private ServicesRepository servicesRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private UtilityService utility;

	@Override
	@Cacheable(value = "services")
	public ResponseEntity<List<Services>> getAll() {
		Users user = userService.getUser(utility.getCurrentUsername()).getBody();
		if (user != null && user.getRole().equals(UserRole.VENDOR)) {
			return ResponseEntity.ok(servicesRepo.findByCreatedBy(vendorService.getVendor(user).getBody()));
		}
		return ResponseEntity.ok(servicesRepo.findAll());
	}

	@Override
	@Cacheable(value = "categories", key = "#serviceId")
	public ResponseEntity<Services> get(Long serviceId) {
		return ResponseEntity.ok(servicesRepo.findById(serviceId).get());
	}

	@Override
	@CachePut(value = "services", key = "#service.serviceId")
	public ResponseEntity<Services> add(Services service) {
		try {
			return ResponseEntity.ok(servicesRepo.save(service));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	@CachePut(value = "services")
	public ResponseEntity<Services> update(Services service) {
		Services dbService = servicesRepo.findById(service.getServiceId()).get();
		if (Objects.nonNull(service.getServiceName()) && !"".equalsIgnoreCase(service.getServiceName())) {
			dbService.setServiceName(service.getServiceName());
		}

		if (Objects.nonNull(service.getServiceDescription()) && !"".equalsIgnoreCase(service.getServiceDescription())) {
			dbService.setServiceDescription(service.getServiceDescription());
		}

		if (Objects.nonNull(service.getStatus())) {
			dbService.setStatus(service.getStatus());
		}

		if (Objects.nonNull(service.getServicecategory())
				&& !dbService.getServicecategory().equals(service.getServicecategory())) {
			dbService.setServicecategory(service.getServicecategory());
		}
		try {
			return ResponseEntity.ok(servicesRepo.save(dbService));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	@CacheEvict(value = "services", key = "#service.serviceId")
	public ResponseEntity<String> delete(Services service) {
		try {
			servicesRepo.delete(service);
			return ResponseEntity.ok("Service Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(e.getMessage());
		}
	}

	@Override
	public Long getServices() {
		return servicesRepo.count();
	}

	@Override
	public Long getActiveServices() {
		return servicesRepo.countByStatus(true);
	}

}
