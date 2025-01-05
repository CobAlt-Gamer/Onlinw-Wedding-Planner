package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.entity.ServiceCategories;

public interface ServicecategoryService {

	/**
	 * returns all the {@link ServiceCategories} list
	 *
	 * @return {@link ResponseEntity<List<ServiceCategories>>}
	 */
	ResponseEntity<List<ServiceCategories>> getAllServiceCategories();

	/**
	 * addsServiceCategory to the database
	 *
	 * @param serviceCategoryName
	 * @param icon
	 * @param isActive
	 * @return {@link ResponseEntity<ServiceCategories>} added
	 *         {@link ServiceCategories}
	 */
	ResponseEntity<ServiceCategories> addServiceCategories(String serviceCategoryName, MultipartFile icon,
			boolean isActive);

	/**
	 * deletes the Service Category referencing provided @param serviceCategoryId
	 *
	 * @return {@link ResponseEntity<String>}
	 */
	ResponseEntity<String> deleteServiceCategories(int serviceCategoryId);

	/**
	 * updates service category
	 *
	 * @param serviceCategoryId
	 * @param serviceCategoryName
	 * @param serviceCategoryIcon
	 * @param isActive
	 * @return {@link ResponseEntity<ServiceCategories>} latest updated entity
	 */
	ResponseEntity<ServiceCategories> editServiceCategories(Integer serviceCategoryId, String serviceCategoryName,
			MultipartFile serviceCategoryIcon, boolean isActive);

}
