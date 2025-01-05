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
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;
import com.wedding.planner.service.VariationOptionService;
import com.wedding.planner.service.VariationService;

@Controller
@RequestMapping("/variations")
public class VariationController {

	@Autowired
	private VariationService service;

	@Autowired
	private VariationOptionService optionService;

	@RequestMapping
	public ModelAndView variations() {
		return new ModelAndView("variations").addObject("variationList", service.getVariations().getBody())
				.addObject("variationOptionList", optionService.getVariationOptions().getBody());
	}

	/********************************************************************
	 * Variations
	 *******************************************************************/

	// get all available variations
	@GetMapping("/variations")
	public ResponseEntity<List<Variation>> getVariations() {
		return service.getVariations();
	}

	@GetMapping("/variations/{service}")
	public ResponseEntity<List<Variation>> getVariations(@PathVariable("service") Services service) {
		return this.service.getVariations(service);
	}

	// add variations
	@PostMapping("/add-variations")
	public ResponseEntity<Variation> addVariation(@RequestParam("variation-name") String variationName,
			@RequestParam("service-category") ServiceCategories category) {
		return service.addVariation(variationName, category);
	}

	// edit variation
	@PutMapping("edit-variations")
	public ResponseEntity<Variation> editVariation(@RequestParam("edit-variation-id") Integer variationId,
			@RequestParam("edit-variation-name") String variationName) {
		return service.editVariation(variationId, variationName);
	}

	@DeleteMapping("/delete-variations/{id}")
	public ResponseEntity<String> deleteVariation(@PathVariable("id") Variation variation) {
		return service.deleteVariation(variation);
	}

	/********************************************************************
	 * Variation Options
	 *******************************************************************/

	// get all available variation options
	@GetMapping("/variation-options")
	public ResponseEntity<List<VariationOption>> getVariationOptions() {
		return optionService.getVariationOptions();
	}

	@GetMapping("/variation-options/{variation}")
	public ResponseEntity<List<VariationOption>> getvariationOptions(@PathVariable("variation") Variation variation) {
		return optionService.getVariationOptions(variation);
	}

	// add variation option
	@PostMapping("/add-variation-options")
	public ResponseEntity<VariationOption> addVariationOption(@RequestParam("variations-select") Variation variation,
			@RequestParam("variation-option-name") String variationOption) {
		return optionService.addVariationOption(variation, variationOption);
	}

	// delete variation option
	@DeleteMapping("/delete-variation-option/{id}")
	public ResponseEntity<String> deleteVariationOption(@PathVariable("id") Integer optionId) {
		return optionService.deleteVariationOption(optionId);
	}

}
