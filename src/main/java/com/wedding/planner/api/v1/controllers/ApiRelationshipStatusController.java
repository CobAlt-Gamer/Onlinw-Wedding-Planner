package com.wedding.planner.api.v1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedding.planner.entity.RelationshipStatus;
import com.wedding.planner.service.RelationshipStatusService;

@RestController
@RequestMapping("/api/v1/relation")
public class ApiRelationshipStatusController {

	@Autowired
	private RelationshipStatusService relationshipStatusService;

	@GetMapping
	ResponseEntity<List<RelationshipStatus>> getStatus() {
		return relationshipStatusService.getStatus();
	}

	@PostMapping("{relation}")
	ResponseEntity<RelationshipStatus> addStatus(@PathVariable("relation") String relation) {
		return relationshipStatusService.addStatus(RelationshipStatus.builder().relationshipName(relation).build());
	}

	@PutMapping
	ResponseEntity<RelationshipStatus> updateStatus(@RequestBody RelationshipStatus status) {
		return relationshipStatusService.updateStatus(status);
	}

	@DeleteMapping("{relation}")
	ResponseEntity<Boolean> deleteStatus(@PathVariable("relation") RelationshipStatus relation) {
		return relationshipStatusService.deleteStatus(relation);
	}
}
