package com.wedding.planner.service;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.Couple;
import com.wedding.planner.entity.Users;
import com.wedding.planner.enums.CoupleRole;

public interface CoupleService {

	/**
	 * creates Couple
	 * @param user
	 * @param role
	 * @return
	 */
	ResponseEntity<Couple> addCouple(Users user, CoupleRole role);

	/**
	 * Gets Couple By User
	 * @param user
	 * @return
	 */
	ResponseEntity<Couple> getCouple(Users user);

	/**
	 * Updates Couple
	 * @param couple
	 * @return
	 */
	ResponseEntity<Couple> updateCouple(Couple couple);

	/**
	 * deletes Couple
	 * @param couple
	 * @return
	 */
	ResponseEntity<Boolean> deleteCouple(Couple couple);

}
