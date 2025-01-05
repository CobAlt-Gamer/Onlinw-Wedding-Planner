package com.wedding.planner.api.v1.service;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.AddressDTO;
import com.wedding.planner.api.v1.dto.CitiesDTO;
import com.wedding.planner.entity.Address;
import com.wedding.planner.entity.Cities;

public interface ApiAddressService {

	/**
	 * converts {@link Cities} to {@link CitiesDTO}
	 *
	 * @param city
	 * @return
	 */
	private CitiesDTO convertCity(Cities city) {
		return new CitiesDTO(city.getCityId(), city.getCityName());
	}

	/**
	 * Converts {@link Address} to {@link AddressDTO}
	 *
	 * @param address
	 * @return
	 */
	default AddressDTO convertToDTO(Address address) {
		return new AddressDTO(address.getAddressId(), address.getAddressLine1(), address.getAddressLine2(),
				convertCity(address.getCity()));
	}

	/**
	 * adds {@link Address} to Database & returns {@link AddressDTO}
	 *
	 * @param address
	 * @return
	 */
	ResponseEntity<AddressDTO> addAddress(AddressDTO address);

	/**
	 * Gets {@link AddressDTO} based on addressId
	 *
	 * @param addressId
	 * @return
	 */
	ResponseEntity<AddressDTO> getAddress(Long addressId);

	/**
	 * updates {@link Address}
	 *
	 * @param addressData
	 * @return
	 */
	ResponseEntity<AddressDTO> updateAddress(AddressDTO addressData);

	/**
	 * Deletes {@link Address} based on addresId
	 *
	 * @param addressId
	 * @return
	 */
	ResponseEntity<Boolean> deleteAddress(Long addressId);

}
