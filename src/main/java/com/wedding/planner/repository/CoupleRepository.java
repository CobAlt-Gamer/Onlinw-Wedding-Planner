package com.wedding.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Couple;
import com.wedding.planner.entity.Users;

public interface CoupleRepository extends JpaRepository<Couple, Long> {
	Couple findByGroomOrBride(Users groom, Users bride);
}
