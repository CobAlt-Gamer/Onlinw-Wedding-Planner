package com.wedding.planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wedding.planner.entity.ServiceVariation;
import com.wedding.planner.entity.VariationOption;
import com.wedding.planner.service.ServiceVariationService;

@Controller
@RequestMapping("/service-variation")
public class ServiceVariationController {

	@Autowired
	private ServiceVariationService serviceVarService;

	@RequestMapping
	public ModelAndView serviceVariation(ModelAndView mv) {
		mv.setViewName("service-variations");
		return mv;
	}

	/********************************************
	 * Service Variation
	 **********************************************/

//	Adds Service Variation
	@PostMapping("add")
	ResponseEntity<ServiceVariation> add(@RequestParam("select-service-item") Long item,
			@RequestParam("select-variation-option") VariationOption option) {
		ServiceVariation serviceVar = ServiceVariation.builder().item(item).option(option).build();
		return serviceVarService.add(serviceVar);
	}

//	Delete Service Variation
	@DeleteMapping("delete/item/{item}/option/{option}")
	ResponseEntity<String> delete(@PathVariable("item") Long item, @PathVariable("option") VariationOption option) {
		ServiceVariation serviceVar = ServiceVariation.builder().item(item).option(option).build();
		return serviceVarService.delete(serviceVar);
	}
}
