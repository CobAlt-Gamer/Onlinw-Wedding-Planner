package com.wedding.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.States;
import com.wedding.planner.service.CitiesSercvice;

@RequestMapping("/cities")
@Controller
public class CitiesController {

	@Autowired
	private CitiesSercvice citiesService;

	@RequestMapping
	public ResponseEntity<List<Cities>> getCities(@RequestParam("state") States state){
		return citiesService.getCities(state);
	}

}
