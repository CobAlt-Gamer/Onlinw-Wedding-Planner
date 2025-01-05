package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.dto.ImageDTO;
import com.wedding.planner.entity.Images;

public interface ApiImageService {

	/**
	 * converts {@link Images} to {@link ImageDTO}
	 * @param image
	 * @return
	 */
	default ImageDTO convertToDTO(Images image) {
		return new ImageDTO(image.getImageId(), image.getUrl());
	}

	/**
	 * Converts {@link List} of {@link Images} to {@link List} of {@link ImageDTO}
	 * @param images
	 * @return
	 */
	default List<ImageDTO> convertToDTO(List<Images> images) {
		return images.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * gets {@link ImageDTO} based in imageId
	 * @param imageId
	 * @return
	 */
	ResponseEntity<ImageDTO> getImage(Long imageId);

	/**
	 * adds {@link MultipartFile} and Returns {@link ImageDTO}
	 * @param file
	 * @param path
	 * @return
	 */
	ResponseEntity<ImageDTO> addImage(MultipartFile file,String path);

	/**
	 * Updates Old {@link Images} With New Based on imageId and {@link MultipartFile} file
	 * @param imageId
	 * @param file
	 * @return
	 */
	ResponseEntity<ImageDTO> updateImage(Long imageId,MultipartFile file,String path);

	/**
	 * Deletes {@link Images} associated with imageId
	 * @param imageId
	 * @return
	 */
	ResponseEntity<Boolean> deleteImage(Long imageId);

}
