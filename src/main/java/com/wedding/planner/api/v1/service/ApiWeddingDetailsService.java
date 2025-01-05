package com.wedding.planner.api.v1.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.WeddingDetailsDTO;
import com.wedding.planner.entity.WeddingDetails;

public interface ApiWeddingDetailsService {

	/**
	 * Converts {@link WeddingDetails} to {@link WeddingDetailsDTO}
	 *
	 * @param weddingDetails
	 * @return
	 */
	default WeddingDetailsDTO convertToDTO(WeddingDetails weddingDetails) {
		return new WeddingDetailsDTO(weddingDetails.getWeddingDetailsId(), weddingDetails.getWeddingEventName(),
				weddingDetails.getEventDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")),
				weddingDetails.getUser().getUserId().toString());
	}

	/**
	 * Converts {@link List} {@link WeddingDetails} to {@link List} of
	 * {@link WeddingDetailsDTO}
	 *
	 * @param weddingDetails
	 * @return
	 */
	default List<WeddingDetailsDTO> convertToDTO(List<WeddingDetails> weddingDetails) {
		return weddingDetails.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * gets All the {@link WeddingDetailsDTO}
	 *
	 * @return
	 */
	ResponseEntity<List<WeddingDetailsDTO>> getweddingDetails(Optional<Long> user);

	/**
	 * Adds {@link WeddingDetails}
	 *
	 * @param weddingDto
	 * @return
	 */
	ResponseEntity<WeddingDetailsDTO> addWeddingDetails(WeddingDetailsDTO weddingDto);

	/**
	 * Updates {@link WeddingDetails}
	 *
	 * @param weddingDto
	 * @return
	 */
	ResponseEntity<WeddingDetailsDTO> updateWeddingDetails(WeddingDetailsDTO weddingDto);

	/**
	 * Deletes {@link WeddingDetails}
	 *
	 * @param weddingDetailsId
	 * @return
	 */
	ResponseEntity<Boolean> deleteweddingDetails(Long weddingDetailsId);
}