package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.States;
import com.wedding.planner.repository.StatesRepository;
import com.wedding.planner.service.StatesService;

@Service
public class StatesServiceImpl implements StatesService {

	@Autowired
	private StatesRepository statesRepo;

	@Override
	public ResponseEntity<List<States>> getStates() {
		return ResponseEntity.ok(statesRepo.findAll());
	}

	@Override
	public ResponseEntity<States> updateState(States state) {
		Optional<States> dbStates = statesRepo.findById(state.getStateId());
		if (dbStates.isPresent()) {
			if (Objects.nonNull(state.getStateName()) && !"".equalsIgnoreCase(state.getStateName())) {
				dbStates.ifPresent(data -> data.setStateName(state.getStateName()));
			}
			return ResponseEntity.ok(statesRepo.save(dbStates.get()));
		}
		return ResponseEntity.notFound().build();
	}
}