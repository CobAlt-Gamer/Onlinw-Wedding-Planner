package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Images;
import com.wedding.planner.repository.ImagesRepository;
import com.wedding.planner.service.ImageService;

import jakarta.transaction.Transactional;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImagesRepository imageRepo;

	@Override
	public ResponseEntity<Images> getImage(Long imageId) {
		try {
			return ResponseEntity.ok(imageRepo.findById(imageId).get());
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	@Transactional
	public ResponseEntity<Images> addImage(Images image) {
		return ResponseEntity.ok(imageRepo.save(image));
	}

	@Override
	public ResponseEntity<Images> update(Images image) {
		Images dbImage = imageRepo.findById(image.getImageId()).get();
		if (Objects.nonNull(image.getFileId()) && !"".equalsIgnoreCase(image.getFileId())) {
			dbImage.setFileId(image.getFileId());
		}

		if (Objects.nonNull(image.getUrl()) && !"".equalsIgnoreCase(image.getUrl())) {
			dbImage.setUrl(image.getUrl());
		}

		return ResponseEntity.ok(imageRepo.save(image));
	}

	@Override
	public ResponseEntity<Boolean> delete(Images image) {
		try {
			imageRepo.delete(image);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}

	@Override
	public ResponseEntity<Boolean> delete(List<Images> images) {
		try {
			imageRepo.deleteAll(images);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.ok(false);
		}
	}
}
