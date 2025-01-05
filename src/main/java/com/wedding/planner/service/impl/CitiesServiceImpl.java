package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Cities;
import com.wedding.planner.entity.States;
import com.wedding.planner.repository.CitiesRepository;
import com.wedding.planner.service.CitiesSercvice;

@Service
public class CitiesServiceImpl implements CitiesSercvice {

	@Autowired
	private CitiesRepository citiesRepo;

	@Override
	public ResponseEntity<List<Cities>> getCities() {
		return ResponseEntity.ok(citiesRepo.findAll());
	}

	@Override
	public ResponseEntity<List<Cities>> getCities(States state) {
		return ResponseEntity.ok(citiesRepo.findByState(state));
	}

	@Override
	public ResponseEntity<Cities> updateCity(Cities city) {
		Optional<Cities> dbCity = citiesRepo.findById(city.getCityId());

		if (dbCity.isPresent()) {
			if (Objects.nonNull(city.getCityName()) && !"".equalsIgnoreCase(city.getCityName())) {
				dbCity.ifPresent(data -> data.setCityName(city.getCityName()));
			}
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.notFound().build();
	}

}
