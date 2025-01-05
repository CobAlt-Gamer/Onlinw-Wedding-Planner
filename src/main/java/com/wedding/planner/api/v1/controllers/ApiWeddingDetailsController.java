package com.wedding.planner.api.v1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.WeddingDetailsDTO;
import com.wedding.planner.api.v1.service.ApiWeddingDetailsService;

@RestController
@RequestMapping("/api/v1/wedding-details")
public class ApiWeddingDetailsController {

	@Autowired
	private ApiWeddingDetailsService detailsService;

	@GetMapping
	ResponseEntity<List<WeddingDetailsDTO>> getWeddingDetails(
			@RequestParam(name = "user", required = false) Long user) {
		return detailsService.getweddingDetails(user != null ? Optional.of(user) : Optional.empty());
	}

	@PostMapping
	ResponseEntity<WeddingDetailsDTO> addWeddingDetail(@RequestBody WeddingDetailsDTO details) {
		return detailsService.addWeddingDetails(details);
	}

	@PutMapping
	ResponseEntity<WeddingDetailsDTO> updateWeddingDetails(@RequestBody WeddingDetailsDTO details) {
		return detailsService.updateWeddingDetails(details);
	}

	@DeleteMapping("{detail}")
	ResponseEntity<Boolean> deleteWeddingDetails(@PathVariable("detail") Long weddingDetailsId) {
		return detailsService.deleteweddingDetails(weddingDetailsId);
	}

}
