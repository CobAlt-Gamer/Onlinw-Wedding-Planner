package com.wedding.planner.api.v1.dto;

import java.util.Objects;

public record ServiceCategoryDTO(Integer serviceCategoryId, String serviceCategoryName, String icon) {
	public ServiceCategoryDTO {
		Objects.requireNonNull(serviceCategoryId, "service category id required");
	}
}