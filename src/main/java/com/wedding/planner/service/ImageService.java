package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Images;

public interface ImageService {


	/**
	 * gets {@link Images} based on the imageId
	 * @param imageId
	 * @return {@link ResponseEntity<Images>}
	 */
	ResponseEntity<Images> getImage(Long imageId);

	/**
	 * add Images to the database
	 *
	 * @param image
	 * @return {@link ResponseEntity<Images>} added {@link Images}
	 */
	ResponseEntity<Images> addImage(Images image);

	/**
	 * updates existing Images to provided @param image
	 *
	 * @param image
	 * @return {@link ResponseEntity<Images>} updated {@link Images}
	 */
	ResponseEntity<Images> update(Images image);

	/**
	 * deletes if the @param image exists in the database
	 *
	 * @param image
	 * @return {@link ResponseEntity<Boolean>} whether the image entity is deleted
	 */
	ResponseEntity<Boolean> delete(Images image);

	/**
	 * deletes if the @param images exists in the database
	 *
	 * @param images
	 * @return {@link ResponseEntity<Boolean>} whether the images are deleted
	 */
	ResponseEntity<Boolean> delete(List<Images> images);

}
