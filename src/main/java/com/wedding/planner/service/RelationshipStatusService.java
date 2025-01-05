package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.RelationshipStatus;

public interface RelationshipStatusService {

	/**
	 * Gets {@link List} of {@link RelationshipStatus}
	 * @return
	 */
	ResponseEntity<List<RelationshipStatus>> getStatus();

	/**
	 * Adds {@link RelationshipStatus}
	 * @param status
	 * @return
	 */
	ResponseEntity<RelationshipStatus> addStatus(RelationshipStatus status);

	/**
	 * Updates Existing {@link RelationshipStatus}
	 * @param status
	 * @return
	 */
	ResponseEntity<RelationshipStatus> updateStatus(RelationshipStatus status);

	/**
	 * Removes {@link RelationshipStatus}
	 * @param status
	 * @return
	 */
	ResponseEntity<Boolean> deleteStatus(RelationshipStatus status);

	/**
	 * Gets Status By Name
	 * @param status
	 * @return
	 */
	ResponseEntity<RelationshipStatus> getStatus(String status);

	/**
	 * Gets Status By Id
	 * @param status
	 * @return
	 */
	ResponseEntity<RelationshipStatus> getsStatus(Integer statusId);

}
