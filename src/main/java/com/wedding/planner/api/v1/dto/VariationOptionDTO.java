package com.wedding.planner.api.v1.dto;

import java.util.Objects;

public record VariationOptionDTO(
        Integer variationOptionId,
        String variationOptionName) {
    public VariationOptionDTO {
        Objects.requireNonNull(variationOptionId, "option id required");
        Objects.requireNonNull(variationOptionName, "option NAME required");
    }
}
