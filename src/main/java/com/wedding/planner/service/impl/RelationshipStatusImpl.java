package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.RelationshipStatus;
import com.wedding.planner.repository.RelationshipStatusRepository;
import com.wedding.planner.service.RelationshipStatusService;

@Service
public class RelationshipStatusImpl implements RelationshipStatusService {

	@Autowired
	private RelationshipStatusRepository statusRepo;

	@Override
	public ResponseEntity<List<RelationshipStatus>> getStatus() {
		return ResponseEntity.ok(statusRepo.findAll());
	}

	@Override
	public ResponseEntity<RelationshipStatus> addStatus(RelationshipStatus status) {
		return ResponseEntity.ok(statusRepo.save(status));
	}

	@Override
	public ResponseEntity<RelationshipStatus> updateStatus(RelationshipStatus status) {
		Optional<RelationshipStatus> dbStatus = statusRepo.findById(status.getRelationshipId());

		if (dbStatus.isPresent()) {
			dbStatus.get().setRelationshipName(status.getRelationshipName());
			return ResponseEntity.ok(statusRepo.save(dbStatus.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteStatus(RelationshipStatus status) {
		try {
			statusRepo.delete(status);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

	@Override
	public ResponseEntity<RelationshipStatus> getStatus(String status) {
		return ResponseEntity.ok(statusRepo.findByRelationshipNameIgnoreCase(status));
	}

	@Override
	public ResponseEntity<RelationshipStatus> getsStatus(Integer statusId) {
		return ResponseEntity.ok(statusRepo.findById(statusId).get());
	}

}
