package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.States;

public interface CitiesSercvice {

	/**
	 * gets All the Cities
	 * @return
	 */
	ResponseEntity<List<Cities>> getCities();

	/**
	 * gets All the Cities under provided {@link States}
	 * @param state
	 * @return
	 */
	ResponseEntity<List<Cities>> getCities(States state);

	/**
	 * Updates City
	 * @param city
	 * @return
	 */
	ResponseEntity<Cities> updateCity(Cities city);

}
