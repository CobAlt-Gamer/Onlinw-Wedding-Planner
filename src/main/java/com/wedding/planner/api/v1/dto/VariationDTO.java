package com.wedding.planner.api.v1.dto;

import java.util.Objects;

public record VariationDTO(Integer variationId, String variationName) {
	public VariationDTO {
        Objects.requireNonNull(variationId,"variation id is required");
        Objects.requireNonNull(variationName,"variation NAME is required");
    }
}
