package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Services;

public interface ServicesService {

	/**
	 * gets All the {@link Services} Entities in list from database
	 *
	 * @return {@link ResponseEntity<List<Services>>}
	 */
	ResponseEntity<List<Services>> getAll();

	/**
	 * Gets Service By serviceId
	 * @param serviceId
	 * @return
	 */
	ResponseEntity<Services> get(Long serviceId);

	/**
	 * adds the provided {@link Services} entity to the database
	 *
	 * @param service
	 * @return {@link ResponseEntity<Services>} latest added Entity
	 */
	ResponseEntity<Services> add(Services service);

	/**
	 * Updates the {@link Services}
	 *
	 * @param service
	 * @return {@link ResponseEntity<Services>} updated {@link Services} entity
	 */
	ResponseEntity<Services> update(Services service);

	/**
	 * Deletes the Provided {@link Services}
	 *
	 * @param service
	 * @return {@link ResponseEntity<String>} response text
	 */
	ResponseEntity<String> delete(Services service);

	/**
	 * Gets Count of services Available
	 * @return
	 */
	Long getServices();

	/**
	 * Gets Active Services
	 * @return
	 */
	Long getActiveServices();

}
