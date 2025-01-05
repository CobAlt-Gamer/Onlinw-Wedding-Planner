package com.wedding.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.RelationshipStatus;

public interface RelationshipStatusRepository extends JpaRepository<RelationshipStatus, Integer> {

	RelationshipStatus findByRelationshipNameIgnoreCase(String relationshipName);

}
