package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.api.v1.dto.StatesDTO;
import com.wedding.planner.api.v1.service.ApiStatesService;

@RestController
@RequestMapping("/api/v1/states")
public class ApiStatesController {

	@Autowired
	private ApiStatesService statesService;

	@GetMapping
	public ResponseEntity<List<StatesDTO>> states() {
		return statesService.getStates();
	}

}
