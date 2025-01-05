package com.wedding.planner.service;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.ServiceVariation;

public interface ServiceVariationService {

	/**
	 * Adds Provided {@link ServiceVariation} into database
	 *
	 * @param variation
	 * @return {@link ResponseEntity<ServiceVariation>} added
	 *         {@link ServiceVariation} entity
	 */
	ResponseEntity<ServiceVariation> add(ServiceVariation variation);

	/**
	 * Deletes given {@link ServiceVariation}
	 *
	 * @param variation
	 * @return {@link ResponseEntity<Sring>} Response string
	 */
	ResponseEntity<String> delete(ServiceVariation variation);

}
