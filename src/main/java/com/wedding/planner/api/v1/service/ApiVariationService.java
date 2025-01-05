package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.VariationDTO;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Variation;

public interface ApiVariationService {

	/**
	 * Converts {@link Variation} to {@link VariationDTO}
	 *
	 * @param variation
	 * @return {@link VariationDTO}
	 */
	default VariationDTO convertToDTO(Variation variation) {
		return new VariationDTO(variation.getVariationId(), variation.getVariationName());
	}

	/**
	 * Converts {@link List} of {@link Variation} to {@link List<VariationDTO>}
	 *
	 * @param variations
	 * @return {@link List} of {@link VariationDTO}
	 */
	default List<VariationDTO> convertToDTO(List<Variation> variations) {
		return variations.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * returns All the available variations in {@link VariationDTO}
	 *
	 * @return {@link ResponseDTO} of {@link List<VariationDTO>}
	 */
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations();

	/**
	 * returns All the available variations in {@link VariationDTO}
	 *
	 * @param page
	 * @return {@link ResponseDTO} of {@link List<VariationDTO>}
	 */
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(Pageable page);

	/**
	 * returns All the available variations in {@link VariationDTO}
	 *
	 * @param category
	 * @return {@link ResponseDTO} of {@link List<VariationDTO>}
	 */
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(ServiceCategories category);

	/**
	 * returns All the available variations in {@link VariationDTO}
	 *
	 * @param category
	 * @param page
	 * @return {@link ResponseDTO} of {@link List<VariationDTO>}
	 */
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(ServiceCategories category, Pageable page);
}
