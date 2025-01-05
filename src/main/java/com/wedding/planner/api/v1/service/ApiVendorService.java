package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.VendorDTO;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.Vendor;

public interface ApiVendorService {

	/**
	 * Converts {@link Vendor} to {@link VendorDTO}
	 * @param vendor
	 * @return
	 */
	default VendorDTO convertToDTO(Vendor vendor) {
		return new VendorDTO(vendor.getVendorId(), vendor.getBusinessName(), vendor.getBusinessContact(),
				vendor.getUser().getUserId().toString());
	}

	/**
	 * Converts {@link List} {@link Vendor} to {@link List} {@link VendorDTO}
	 * @param vendors
	 * @return
	 */
	default List<VendorDTO> convertToDTO(List<Vendor> vendors) {
		return vendors.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets {@link VendorDTO} By {@link Services}
	 * @param serviceId
	 * @return
	 */
	ResponseEntity<VendorDTO> getVendorByService(Long serviceId);

	/**
	 * Gets {@link VendorDTO} by {@link Users}
	 * @param userId
	 * @return
	 */
	ResponseEntity<VendorDTO> getVendorByUser(Long userId);

	/**
	 * Gets {@link VendorDTO} by {@link ServiceItem}
	 * @param serviceItemId
	 * @return
	 */
	ResponseEntity<VendorDTO> getVendorByServiceItem(Long serviceItemId);

}
