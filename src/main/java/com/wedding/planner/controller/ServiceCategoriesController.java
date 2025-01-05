package com.wedding.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.service.ServicecategoryService;

@Controller
@RequestMapping("/service-categories")
public class ServiceCategoriesController {

	@Autowired
	private ServicecategoryService service;

	@RequestMapping
	public ModelAndView serviceCategories() {
		return new ModelAndView("service-categories").addObject("serviceCategories",
				getAllServiceCategories().getBody());
	}

	/********************************************************************
	 * Service Categories
	 *******************************************************************/

//	all available service categories
	@GetMapping("/categories")
	public ResponseEntity<List<ServiceCategories>> getAllServiceCategories() {
		return service.getAllServiceCategories();
	}

//	adds category
	@PostMapping("/add-service-categories")
	public ResponseEntity<ServiceCategories> addServiceCategories(
			@RequestParam("serviceCategoryName") String serviceCategoryName,
			@RequestParam("serviceCategoryIcon") MultipartFile serviceCategoryIcon,
			@RequestParam(name = "isActive", required = false, defaultValue = "1") boolean isActive) {
		return service.addServiceCategories(serviceCategoryName, serviceCategoryIcon, isActive);
	}

//	deletes category
	@DeleteMapping("/delete-service-categories/{id}")
	public ResponseEntity<String> deleteServiceCategories(@PathVariable("id") int serviceCategoryId) {
		return service.deleteServiceCategories(serviceCategoryId);
	}

//	edit category
	@PutMapping("/edit-service-categories")
	public ResponseEntity<ServiceCategories> editServiceCategories(
			@RequestParam("edit-service-category-id") Integer serviceCategoryId,
			@RequestParam("edit-service-category-name") String serviceCategoryName,
			@RequestParam(name = "edit-category-image", required = false) MultipartFile serviceCategoryIcon,
			@RequestParam("edit-service-category-status") boolean isActive) {
		return service.editServiceCategories(serviceCategoryId, serviceCategoryName, serviceCategoryIcon, isActive);
	}

}
