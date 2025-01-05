package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.States;

public interface StatesService {

	/**
	 * Gets All the States
	 * @return
	 */
	ResponseEntity<List<States>> getStates();

	/**
	 * updates the State
	 * @param state
	 * @return
	 */
	ResponseEntity<States> updateState(States state);
}
