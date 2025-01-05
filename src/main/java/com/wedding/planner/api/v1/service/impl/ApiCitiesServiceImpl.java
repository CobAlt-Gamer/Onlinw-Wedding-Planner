package com.wedding.planner.api.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.CitiesDTO;
import com.wedding.planner.api.v1.service.ApiCitiesService;
import com.wedding.planner.entity.States;
import com.wedding.planner.repository.CitiesRepository;

@Service
public class ApiCitiesServiceImpl implements ApiCitiesService {

	@Autowired
	private CitiesRepository citiesRepo;

	@Override
	public ResponseEntity<List<CitiesDTO>> getCities(States state) {
		return ResponseEntity.ok(convertToDTO(citiesRepo.findByState(state)));
	}

}
