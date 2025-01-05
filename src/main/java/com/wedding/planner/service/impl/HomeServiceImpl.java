package com.wedding.planner.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.dto.StatisticsDTO;
import com.wedding.planner.enums.UserRole;
import com.wedding.planner.service.HomeService;
import com.wedding.planner.service.ServicesService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.service.VendorService;

@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private UserService userService;

	@Autowired
	private VendorService vendorService;

	@Autowired
	private ServicesService service;

	@Override
	@Cacheable(value = "statistics")
	public ResponseEntity<StatisticsDTO> getStatistics() {

		LocalDateTime dateBefore15Days = LocalDateTime.now().minusDays(15);

		Long users = userService.getUsersCount(UserRole.USER);
		Integer newUsers = userService.getUserCount(UserRole.USER, dateBefore15Days);
		Long vendors = userService.getUsersCount(UserRole.VENDOR);
		Integer approvedVendors = vendorService.getApprovedVendors();
		Long serviceCounts = service.getServices();
		Long activeServices = service.getActiveServices();

		StatisticsDTO statistics = new StatisticsDTO(users, newUsers, vendors, approvedVendors, serviceCounts,
				activeServices);

		return ResponseEntity.ok(statistics);
	}

}
