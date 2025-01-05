package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceCategoryDTO;
import com.wedding.planner.entity.ServiceCategories;

public interface ApiServiceCategoryService {

	/**
	 * Converts {@link ServiceCategories} to {@link ServiceCategoryDTO}
	 *
	 * @param category
	 * @return {@link ServiceCategoryDTO}
	 */
	default ServiceCategoryDTO convertToDTO(ServiceCategories category) {
		return new ServiceCategoryDTO(category.getServiceCategoryId(), category.getServiceCategoryName(),
				category.getCategoryIcon().getUrl());
	}

	/**
	 * Converts {@link List<ServiceCategories>} to {@link List<ServiceCategoryDTO>}
	 *
	 * @param category
	 * @return {@link List<ServiceCategoryDTO>}
	 */
	default List<ServiceCategoryDTO> convertToDTO(List<ServiceCategories> category) {
		return category.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets Service category
	 *
	 * @param categoryId
	 * @return {@link ServiceCategories}
	 */
	ServiceCategories getServiceCategory(Integer categoryId);

	/**
	 * List of Service Categories
	 *
	 * @return {@link ResponseDTO} of {@link List<ServiceCategoryDTO>}
	 */
	ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories();

	/**
	 * List of Service Categories
	 *
	 * @param page
	 * @return {@link ResponseDTO} of {@link List<ServiceCategoryDTO>}
	 */
	ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories(Pageable page);
}
