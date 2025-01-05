package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.ServiceVariation;
import com.wedding.planner.entity.Services;

public interface ServiceItemService {

	/**
	 * Gets All the {@link ServiceItem} from the database
	 *
	 * @return {@link ResponseEntity<List<ServiceItem>>} list of {@link ServiceItem}
	 */
	ResponseEntity<List<ServiceItem>> getAll();

	/**
	 * gets All the Service Items Associated with Service
	 *
	 * @param service
	 * @return {@link ResponseEntity<List<ServiceItem>>} list of {@link ServiceItem}
	 */
	ResponseEntity<List<ServiceItem>> getAll(Services service);

	/**
	 * adds the {@link ServiceItem} to database
	 *
	 * @param itemName
	 * @param service
	 * @param approxPrice
	 * @param itemImages
	 * @return {@link ResponseEntity<ServiceItem>} added {@link ServiceItem}
	 */
	ResponseEntity<ServiceItem> add(String itemName, Services service, Double approxPrice, Boolean status,
			MultipartFile[] itemImages);

	/**
	 * Deletes the Service Item From The database
	 *
	 * @param item
	 * @return {@link ResponseEntity<String>} response text
	 */
	ResponseEntity<String> delete(ServiceItem item);

	/**
	 * Deletes the Service Variation From The database
	 *
	 * @param item
	 * @return {@link ResponseEntity<String>} response text
	 */
	ResponseEntity<String> delete(ServiceVariation variation);


	/**
	 * Gets Service Item For Given ServiceItemId
	 *
	 * @param serviceItemId
	 * @return {@link ResponseEntity<ServiceItem>}
	 */
	ResponseEntity<ServiceItem> get(Long serviceItemId);

	/**
	 * Updates existing Service Item And returns the updated entity
	 *
	 * @param itemName
	 * @param approxPrice
	 * @param service
	 * @return {@link ResponseEntity<ServiceItem>} updates {@link ServiceItem}
	 */
	ResponseEntity<ServiceItem> update(ServiceItem item);

	/**
	 * Updates existing Service Item and Adds Variation
	 *
	 * @param variation
	 * @return
	 */
	ResponseEntity<ServiceVariation> update(ServiceVariation variation);
}
