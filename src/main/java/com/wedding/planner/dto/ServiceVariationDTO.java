package com.wedding.planner.dto;

import java.util.List;

import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.ServiceVariation;
import com.wedding.planner.entity.Services;

public record ServiceVariationDTO (
		List<Services> services,
		List<ServiceItem> items,
		List<ServiceVariation> variations){}
