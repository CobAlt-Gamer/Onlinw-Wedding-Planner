package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceCategoryDTO;
import com.wedding.planner.api.v1.service.ApiServiceCategoryService;

@RestController
@RequestMapping("/api/v1/service-category")
public class ApiServiceCategoryController {

	@Autowired
	private ApiServiceCategoryService categoryService;

	@GetMapping
	public ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories() {
		return categoryService.serviceCategories();
	}

	@GetMapping("page/{page}/size/{size}")
	public ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories(
			@PathVariable(name = "page") Integer page, @PathVariable(name = "size") Integer size) {
		return categoryService.serviceCategories(PageRequest.of(page, size));
	}
}
