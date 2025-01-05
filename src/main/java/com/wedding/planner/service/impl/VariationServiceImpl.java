package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Variation;
import com.wedding.planner.repository.VariationRepository;
import com.wedding.planner.service.VariationOptionService;
import com.wedding.planner.service.VariationService;

@Service
public class VariationServiceImpl implements VariationService {

	@Autowired
	VariationRepository variationRepo;

	@Autowired
	VariationOptionService optionService;

	@Override
	@Cacheable(value = "variations")
	public ResponseEntity<List<Variation>> getVariations() {
		return ResponseEntity.ok().body(variationRepo.findAll());
	}

	@Override
	@Cacheable(value = "variations", key = "#service.serviceId")
	public ResponseEntity<List<Variation>> getVariations(Services service) {
		try {
			List<Variation> variations = variationRepo.findByServiceCategory(service.getServicecategory());
			if (variations.size() == 0) {
				throw new Exception("No Variations Exist");
			}
			return ResponseEntity.ok(variations);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<Variation> addVariation(String variationName, ServiceCategories category) {
		try {
			return ResponseEntity.ok().body(variationRepo
					.save(Variation.builder().variationName(variationName).serviceCategory(category).build()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	@CachePut(value = "variations")
	public ResponseEntity<Variation> editVariation(Integer variationId, String variationName) {
		Variation dbVariation = variationRepo.findById(variationId).get();
		if (Objects.nonNull(variationName) && !"".equals(variationName)) {
			dbVariation.setVariationName(variationName);
		}
		return ResponseEntity.ok().body(variationRepo.save(dbVariation));
	}

	@Override
	@CacheEvict(value = "variations", key = "#variation.variationId")
	public ResponseEntity<String> deleteVariation(Variation variation) {
		try {
			optionService.deleteVariationOptionsBy(variation);
			variationRepo.delete(variation);
			return ResponseEntity.ok().body("Variation Deleted Successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Variation Not Found");
		}
	}
}
