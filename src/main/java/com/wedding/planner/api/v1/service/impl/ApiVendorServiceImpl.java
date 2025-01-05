package com.wedding.planner.api.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.VendorDTO;
import com.wedding.planner.api.v1.service.ApiVendorService;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Users;
import com.wedding.planner.repository.VendorRepository;
import com.wedding.planner.service.ServiceItemService;
import com.wedding.planner.service.ServicesService;

@Service
public class ApiVendorServiceImpl implements ApiVendorService {

	@Autowired
	private VendorRepository vendorRepo;

	@Autowired
	private ServicesService serviceService;

	@Autowired
	private ServiceItemService serviceItemService;

	@Override
	@Cacheable(value = "vendorsCache", key = "#serviceId")
	public ResponseEntity<VendorDTO> getVendorByService(Long serviceId) {
		Services service = serviceService.get(serviceId).getBody();
		return ResponseEntity.ok(convertToDTO(service.getCreatedBy()));
	}

	@Override
	@Cacheable(value = "vendorsCache", key = "#userId")
	public ResponseEntity<VendorDTO> getVendorByUser(Long userId) {
		return ResponseEntity.ok(convertToDTO(vendorRepo.findByUser(Users.builder().userId(userId).build())));
	}

	@Override
	@Cacheable(value = "vendorsCache", key = "#serviceItemId")
	public ResponseEntity<VendorDTO> getVendorByServiceItem(Long serviceItemId) {
		ServiceItem item = serviceItemService.get(serviceItemId).getBody();
		return ResponseEntity.ok(convertToDTO(item.getService().getCreatedBy()));
	}

}
