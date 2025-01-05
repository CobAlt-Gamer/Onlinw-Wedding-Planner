package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.StatesDTO;
import com.wedding.planner.entity.States;

public interface ApiStatesService {

	/**
	 * Converts {@link States} to {@link StatesDTO}
	 *
	 * @param state
	 * @return
	 */
	private StatesDTO convertToDTO(States state) {
		return new StatesDTO(state.getStateId(), state.getStateName());
	}

	/**
	 * Converts {@link List} of {@link States} to {@link StatesDTO}
	 *
	 * @param states
	 * @return
	 */
	default List<StatesDTO> convertToDTO(List<States> states) {
		return states.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets the {@link List} of {@link StatesDTO}
	 *
	 * @return
	 */
	ResponseEntity<List<StatesDTO>> getStates();
}
