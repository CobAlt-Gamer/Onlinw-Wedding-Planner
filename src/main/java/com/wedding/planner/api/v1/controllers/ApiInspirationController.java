package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.dto.InspirationDTO;
import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.service.ApiInspirationService;

@RestController
@RequestMapping("/api/v1/inspiration")
public class ApiInspirationController {

	@Autowired
	private ApiInspirationService inspirationService;

	@GetMapping
	ResponseEntity<ResponseDTO<List<InspirationDTO>>> getInspirations() {
		return inspirationService.getAllInspirations();
	}

	@GetMapping("/page/{page}/size/{size}")
	ResponseEntity<ResponseDTO<List<InspirationDTO>>> getInspirations(@PathVariable("page") Integer page,
			@PathVariable("size") Integer size) {
		return inspirationService.getAllInspirations(page, size);
	}

	@GetMapping("{inspiration}")
	ResponseEntity<InspirationDTO> getInspiration(@PathVariable("inspiration") Long inspirationId) {
		return inspirationService.getInspiration(inspirationId);
	}

	@PostMapping
	ResponseEntity<InspirationDTO> addInspiration(@RequestParam("image") MultipartFile file,
			@RequestParam("description") String description, @RequestParam("tags[]") String[] tags) {
		return inspirationService.addInspiration(file, description, tags);
	}

	@PutMapping
	ResponseEntity<InspirationDTO> updateInspiration(@RequestParam("inspirationId") Long inspirationId,
			@RequestParam(name = "image", required = false) MultipartFile file,
			@RequestParam(name = "description", required = false) String description,
			@RequestParam(name = "tags[]", required = false) String tags[]) {
		return inspirationService.updateInspiration(inspirationId, file, description, tags);
	}

	@DeleteMapping("{inspiration}")
	ResponseEntity<Boolean> deleteInspiration(@PathVariable("inspiration") Long inspirationId) {
		return inspirationService.deleteInspiration(inspirationId);
	}
}
