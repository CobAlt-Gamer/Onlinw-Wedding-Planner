package com.wedding.planner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.ServiceVariation;
import com.wedding.planner.service.ServiceItemService;
import com.wedding.planner.service.ServiceVariationService;

@Service
public class ServiceVariationServiceImpl implements ServiceVariationService {


	@Autowired
	private ServiceItemService itemService;


	@Override
	public ResponseEntity<ServiceVariation> add(ServiceVariation variation) {
		try {
			return itemService.update(variation);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<String> delete(ServiceVariation variation) {
		try {
			itemService.delete(variation);
			return ResponseEntity.ok("Service Vaiation Deleted SuccessFully");
		} catch (Exception e) {
			return ResponseEntity.ok("No Service Variation Found");
		}
	}

}
