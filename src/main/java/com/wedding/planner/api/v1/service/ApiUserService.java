package com.wedding.planner.api.v1.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.auth.SignUpRequest;
import com.wedding.planner.api.v1.dto.AddressDTO;
import com.wedding.planner.api.v1.dto.CitiesDTO;
import com.wedding.planner.api.v1.dto.CoupleDTO;
import com.wedding.planner.api.v1.dto.ImageDTO;
import com.wedding.planner.api.v1.dto.UserDTO;
import com.wedding.planner.entity.Address;
import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.Couple;
import com.wedding.planner.entity.Images;
import com.wedding.planner.entity.Users;

public interface ApiUserService {

	/**
	 * converts {@link Images} to {@link ImageDTO}
	 *
	 * @param image
	 * @return
	 */
	default ImageDTO convertToDTO(Images image) {
		return new ImageDTO(image.getImageId(), image.getUrl());
	}

	/**
	 * converts to CitiesDTO
	 *
	 * @param city
	 * @return
	 */
	private CitiesDTO convertCity(Cities city) {
		return new CitiesDTO(city.getCityId(), city.getCityName());
	}

	/**
	 * Converts to AddressDTO
	 *
	 * @param address
	 * @return
	 */
	private AddressDTO convertAddress(Address address) {
		return new AddressDTO(address.getAddressId(), address.getAddressLine1(), address.getAddressLine2(),
				convertCity(address.getCity()));
	}

	/**
	 * Returns User Related data
	 *
	 * @param user
	 * @return
	 */
	default UserDTO convertToDTO(Users user) {
		return new UserDTO(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(),
				user.getAvatar() != null ? convertToDTO(user.getAvatar())
						: new ImageDTO((long) 0, "https://ik.imagekit.io/weddingplanning/defaults/Wedding%20Planner"),
				user.getAddress().size() != 0 ? convertAddress(user.getAddress().get(0)) : null);
	}

	/**
	 * Converts {@link Couple} to {@link CoupleDTO}
	 *
	 * @param couple
	 * @return
	 */
	default CoupleDTO convertToDTO(Couple couple) {
		return new CoupleDTO(couple.getCoupleId(),
				couple.getBride() != null ? couple.getBride().getUserId().toString() : null,
				couple.getGroom() != null ? couple.getGroom().getUserId().toString() : null);
	}

	/**
	 * adds user
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<CoupleDTO> registerUser(SignUpRequest request);

	/**
	 * Adds Couple
	 * @param email
	 * @return
	 */
	ResponseEntity<CoupleDTO> addCouple(String email);

	/**
	 * gets current logged in user
	 *
	 * @return
	 */
	ResponseEntity<UserDTO> getUser();

	/**
	 * Gets user by userId
	 *
	 * @param userId
	 * @return
	 */
	ResponseEntity<UserDTO> getUser(Long userId);

	/**
	 * updates User
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<UserDTO> updateUser(UserDTO user);

	/**
	 * delete User
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<Boolean> deleteUser();

	/**
	 * updates Avatar
	 *
	 * @param file
	 * @return
	 */
	ResponseEntity<ImageDTO> updateAvatar(MultipartFile file);

	/**
	 * Get {@link CoupleDTO}
	 *
	 * @return
	 */
	ResponseEntity<CoupleDTO> getCouple();

}
