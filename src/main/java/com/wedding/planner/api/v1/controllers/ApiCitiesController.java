package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.CitiesDTO;
import com.wedding.planner.api.v1.service.ApiCitiesService;
import com.wedding.planner.entity.States;

@RestController
@RequestMapping("/api/v1/cities")
public class ApiCitiesController {

	@Autowired
	private ApiCitiesService citiesService;

	@GetMapping
	public ResponseEntity<List<CitiesDTO>> cities(@RequestParam("state") States state) {
		return citiesService.getCities(state);
	}

}
