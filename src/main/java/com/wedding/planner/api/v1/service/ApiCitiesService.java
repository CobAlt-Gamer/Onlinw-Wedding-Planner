package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.CitiesDTO;
import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.States;

public interface ApiCitiesService {

	/**
	 * Converts {@link Cities} to {@link CitiesDTO}
	 *
	 * @param city
	 * @return
	 */
	private CitiesDTO convertToDTO(Cities city) {
		return new CitiesDTO(city.getCityId(), city.getCityName());
	}

	/**
	 * Converts {@link List} of {@link Cities} to {@link CitiesDTO}
	 * @param cities
	 * @return
	 */
	default List<CitiesDTO> convertToDTO(List<Cities> cities) {
		return cities.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets {@link List} of {@link CitiesDTO} based on {@link States} Provided
	 * @param state
	 * @return
	 */
	ResponseEntity<List<CitiesDTO>> getCities(States state);

}
