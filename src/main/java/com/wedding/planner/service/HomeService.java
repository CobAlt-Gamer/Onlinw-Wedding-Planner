package com.wedding.planner.service;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.dto.StatisticsDTO;

public interface HomeService {

	/**
	 * Gets The Statistics
	 * @return
	 */
	ResponseEntity<StatisticsDTO> getStatistics();

}
