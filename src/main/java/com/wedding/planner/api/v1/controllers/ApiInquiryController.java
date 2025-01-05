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

import com.wedding.planner.api.v1.dto.InquiryDTO;
import com.wedding.planner.api.v1.service.ApiInquiryService;

@RestController
@RequestMapping("/api/v1/inquiry")
public class ApiInquiryController {

	@Autowired
	private ApiInquiryService inquiryService;

	@GetMapping
	ResponseEntity<List<InquiryDTO>> getInquiries(@RequestParam(name = "user", required = false) Long user) {
		return inquiryService.getInquiries(user != null ? Optional.of(user) : Optional.empty());
	}

	@PostMapping
	ResponseEntity<InquiryDTO> addInquiry(@RequestBody InquiryDTO inquiry) {
		return inquiryService.addInquiry(inquiry);
	}

	@PutMapping
	ResponseEntity<InquiryDTO> updateInquiry(@RequestBody InquiryDTO inquiry) {
		return inquiryService.updateInquiry(inquiry);
	}

	@DeleteMapping("{inquiry}")
	ResponseEntity<Boolean> deleteInquiry(@PathVariable("inquiry") Long inquiryId) {
		return inquiryService.deleteInquiry(inquiryId);
	}
}
