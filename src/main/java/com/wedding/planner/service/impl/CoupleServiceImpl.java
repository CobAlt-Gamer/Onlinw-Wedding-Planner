package com.wedding.planner.service.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Couple;
import com.wedding.planner.entity.Users;
import com.wedding.planner.enums.CoupleRole;
import com.wedding.planner.repository.CoupleRepository;
import com.wedding.planner.service.CoupleService;

@Service
public class CoupleServiceImpl implements CoupleService {

	@Autowired
	private CoupleRepository coupleRepo;

	@Override
	public ResponseEntity<Couple> addCouple(Users user, CoupleRole role) {
		try {
			if (role.equals(CoupleRole.BRIDE)) {
				return ResponseEntity.ok(coupleRepo.save(Couple.builder().bride(user).build()));
			}
			return ResponseEntity.ok(coupleRepo.save(Couple.builder().groom(user).build()));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<Couple> updateCouple(Couple couple) {
		Optional<Couple> dbCouple = coupleRepo.findById(couple.getCoupleId());
		if (dbCouple.isPresent()) {
			if (Objects.nonNull(couple.getBride())) {
				dbCouple.ifPresent(data -> data.setBride(couple.getBride()));
			}
			if (Objects.nonNull(couple.getGroom())) {
				dbCouple.ifPresent(data -> data.setGroom(couple.getGroom()));
			}
			return ResponseEntity.ok(coupleRepo.save(dbCouple.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteCouple(Couple couple) {
		try {
			coupleRepo.delete(couple);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Couple> getCouple(Users user) {
		return ResponseEntity.ok(coupleRepo.findByGroomOrBride(user, user));
	}
}
