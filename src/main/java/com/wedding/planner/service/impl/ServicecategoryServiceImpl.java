package com.wedding.planner.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.entity.Images;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.repository.ServiceCategoriesRepository;
import com.wedding.planner.service.ImageService;
import com.wedding.planner.service.ServicecategoryService;
import com.wedding.planner.service.StorageService;
import com.wedding.planner.utils.impl.Storage;

@Service
public class ServicecategoryServiceImpl implements ServicecategoryService {

	@Autowired
	private ServiceCategoriesRepository dao;

	@Autowired
	private StorageService service;

	@Autowired
	private ImageService imageService;

	@Override
	@Cacheable(value = "categories")
	public ResponseEntity<List<ServiceCategories>> getAllServiceCategories() {

		return ResponseEntity.ok().body(dao.findAll());
	}

	@Override
	@CachePut(value = "categories")
	public ResponseEntity<ServiceCategories> addServiceCategories(String serviceCategoryName, MultipartFile icon,
			boolean isActive) {
		String path = icon.getOriginalFilename();
		ServiceCategories category = ServiceCategories.builder().serviceCategoryName(serviceCategoryName)
				.isActive(isActive).build();
		try {
			Images image = service.upload(icon, path, Storage.STORAGE_CATEGORIES);
			category.setCategoryIcon(image);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(null);
		}

		return ResponseEntity.ok().body(dao.save(category));
	}

	@Override
	@CacheEvict(value = "categories", key = "#servicecategoryId")
	public ResponseEntity<String> deleteServiceCategories(int serviceCategoryId) {
		try {
			ServiceCategories category = dao.findById(serviceCategoryId).get();
			service.delete(category.getCategoryIcon());
			dao.deleteById(serviceCategoryId);
			return ResponseEntity.ok().body("Category Deleted Successfully");
		} catch (Exception e) {
			if (e.getMessage().equals("403")) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN)
						.body("Error deleting Category Image: Permission Denied");
			} else {
				dao.deleteById(serviceCategoryId);
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
			}
		}
	}

	@Override
	@CachePut(value = "categories")
	public ResponseEntity<ServiceCategories> editServiceCategories(Integer serviceCategoryId,
			String serviceCategoryName, MultipartFile serviceCategoryIcon, boolean isActive) {

		ServiceCategories dbCategory = dao.findById(serviceCategoryId).get();
		if (Objects.nonNull(isActive)) {
			dbCategory.setActive(isActive);
		}
		if (Objects.nonNull(serviceCategoryName) && !"".equalsIgnoreCase(serviceCategoryName)) {
			dbCategory.setServiceCategoryName(serviceCategoryName);
		}
		if (Objects.nonNull(serviceCategoryIcon) && !"".equalsIgnoreCase(serviceCategoryIcon.getOriginalFilename())) {
			try {
//				deleting old image
				service.delete(dbCategory.getCategoryIcon());

				Images image = service.upload(serviceCategoryIcon, serviceCategoryIcon.getOriginalFilename(),
						Storage.STORAGE_CATEGORIES);
				image.setImageId(dbCategory.getCategoryIcon().getImageId());
				dbCategory.setCategoryIcon(imageService.update(image).getBody());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.ok().body(dao.save(dbCategory));
	}
}
