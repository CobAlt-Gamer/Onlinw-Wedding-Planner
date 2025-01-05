package com.wedding.planner.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.AddressDTO;
import com.wedding.planner.api.v1.service.ApiAddressService;

@RestController
@RequestMapping("/api/v1/address")
public class ApiAddressController {

	@Autowired
	private ApiAddressService addressService;

	@GetMapping("{address}")
	public ResponseEntity<AddressDTO> getAddress(@PathVariable("address") Long addressId) {
		return addressService.getAddress(addressId);
	}

	@PostMapping
	public ResponseEntity<AddressDTO> addAddress(@RequestBody AddressDTO address) {
		return addressService.addAddress(address);
	}

	@PutMapping
	public ResponseEntity<AddressDTO> updateAddress(@RequestBody AddressDTO address) {
		return addressService.updateAddress(address);
	}

	@DeleteMapping("{address}")
	public ResponseEntity<Boolean> deleteAddress(@PathVariable("address") Long addressId){
		return addressService.deleteAddress(addressId);
	}

}
