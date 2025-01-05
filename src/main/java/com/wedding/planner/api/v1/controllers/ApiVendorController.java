package com.wedding.planner.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.VendorDTO;
import com.wedding.planner.api.v1.service.ApiVendorService;

@RestController
@RequestMapping("/api/v1/vendor")
public class ApiVendorController {

	@Autowired
	private ApiVendorService vendorService;

	@GetMapping("user/{user}")
	ResponseEntity<VendorDTO> getVendorByUser(@PathVariable("user") Long user) {
		return vendorService.getVendorByUser(user);
	}

	@GetMapping("/service/{service}")
	ResponseEntity<VendorDTO> getVendorService(@PathVariable("service") Long service) {
		return vendorService.getVendorByService(service);
	}

	@GetMapping("/service-item/{item}")
	ResponseEntity<VendorDTO> getVendorServiceItem(@PathVariable("item") Long serviceItem) {
		return vendorService.getVendorByServiceItem(serviceItem);
	}

}
