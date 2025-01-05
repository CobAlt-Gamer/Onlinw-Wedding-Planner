package com.wedding.planner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;
import com.wedding.planner.repository.VariationOptionRepository;
import com.wedding.planner.service.VariationOptionService;

@Service
public class VariationOptionServiceImpl implements VariationOptionService {

	@Autowired
	VariationOptionRepository optionRepo;

	@Override
	public ResponseEntity<List<VariationOption>> getVariationOptions() {
		return ResponseEntity.ok().body(optionRepo.findAll());
	}

	@Override
	public ResponseEntity<List<VariationOption>> getVariationOptions(Variation variation) {
		try {
			List<VariationOption> options = optionRepo.findByVariation(variation);
			if (options.size() == 0) {
				throw new Exception("No VariationOptions Found");
			}
			return ResponseEntity.ok(options);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<VariationOption> getVariationOption(Integer optionId) {
		return ResponseEntity.ok().body(optionRepo.findById(optionId).get());
	}

	@Override
	public ResponseEntity<VariationOption> addVariationOption(Variation variation, String variationOption) {
		try {
			return ResponseEntity.ok().body(optionRepo
					.save(VariationOption.builder().variationOptionName(variationOption).variation(variation).build()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ResponseEntity<String> deleteVariationOption(Integer optionId) {
		try {
			optionRepo.deleteById(optionId);
			return ResponseEntity.ok().body("Variation Option Deleted");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Variation Option Not Found");
		}
	}

	@Override
	public ResponseEntity<Boolean> deleteVariationOptionsBy(Variation variation) {
		try {
			optionRepo.deleteAll(optionRepo.findByVariation(variation));
			return ResponseEntity.ok().body(true);
		} catch (Exception e) {
			return ResponseEntity.ok().body(false);
		}
	}

}
