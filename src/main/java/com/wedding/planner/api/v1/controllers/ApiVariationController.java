package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.VariationDTO;
import com.wedding.planner.api.v1.service.ApiVariationService;
import com.wedding.planner.entity.ServiceCategories;

@RestController
@RequestMapping("/api/v1/variation")
public class ApiVariationController {

	@Autowired
	private ApiVariationService variationService;

	@GetMapping
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations() {
		return variationService.variations();
	}

	@GetMapping("page/{page}/size/{size}")
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(@PathVariable(name = "page") Integer page,
			@PathVariable(name = "size") Integer size) {
		return variationService.variations(PageRequest.of(page, size));
	}

	@GetMapping("category")
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(@RequestParam("category") ServiceCategories category) {
		return variationService.variations(category);
	}

	@GetMapping("category/page/{page}/size/{size}")
	ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(@RequestParam("category") ServiceCategories category,
			@PathVariable("page") Integer page,@PathVariable("size") Integer size) {
		return variationService.variations(category, PageRequest.of(page, size));
	}
}
