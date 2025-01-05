package com.wedding.planner.api.v1.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.exception.ApiErrorResponse;
import com.wedding.planner.api.exception.ApiException;
import com.wedding.planner.api.v1.dto.ImageDTO;
import com.wedding.planner.api.v1.service.ApiImageService;
import com.wedding.planner.repository.ImagesRepository;
import com.wedding.planner.service.StorageService;

public class ApiImageServiceImpl implements ApiImageService {

	@Autowired
	private StorageService storageService;

	@Autowired
	private ImagesRepository imageRepo;

	@Override
	public ResponseEntity<ImageDTO> getImage(Long imageId) {
		return ResponseEntity.ok(convertToDTO(imageRepo.findById(imageId).get()));
	}

	@Override
	public ResponseEntity<ImageDTO> addImage(MultipartFile file, String path) {
		try {
			return ResponseEntity.ok(convertToDTO(storageService.upload(file, file.getName(), path)));
		} catch (IOException e) {
			throw new ApiException(new ApiErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
		}
	}

	@Override
	public ResponseEntity<ImageDTO> updateImage(Long imageId, MultipartFile file, String path) {
		try {
			return ResponseEntity.ok(convertToDTO(storageService.upload(file, file.getName(), path, imageId)));
		} catch (IOException e) {
			throw new ApiException(new ApiErrorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
		}

	}

	@Override
	public ResponseEntity<Boolean> deleteImage(Long imageId) {
		try {
			return ResponseEntity.ok(storageService.delete(imageRepo.findById(imageId).get()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}
}
