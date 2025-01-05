package com.wedding.planner.api.v1.dto;

import java.util.List;
import java.util.Objects;

public record ServiceItemDTO(
        Long serviceItemId,
        String itemName,
        Double approxPrice,
        List<String> images) {
    public ServiceItemDTO {
        Objects.requireNonNull(serviceItemId, "service item id is required");
        Objects.requireNonNull(itemName, "item NAME is required");
        Objects.requireNonNull(approxPrice, "approx price is required");
        Objects.requireNonNull(images, "images is required");
        if (images.isEmpty()) {
            throw new IllegalArgumentException("images is empty");
        }
    }
}
