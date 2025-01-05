package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.States;

public interface CitiesRepository extends JpaRepository<Cities, Integer>{

	List<Cities> findByState(States state);
}
