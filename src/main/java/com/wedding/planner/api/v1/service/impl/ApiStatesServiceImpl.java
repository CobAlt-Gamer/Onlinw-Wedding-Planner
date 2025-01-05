package com.wedding.planner.api.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.StatesDTO;
import com.wedding.planner.api.v1.service.ApiStatesService;
import com.wedding.planner.repository.StatesRepository;

@Service
public class ApiStatesServiceImpl implements ApiStatesService {

	@Autowired
	private StatesRepository statesRepo;

	@Override
	public ResponseEntity<List<StatesDTO>> getStates() {
		return ResponseEntity.ok(convertToDTO(statesRepo.findAll()));
	}

}
