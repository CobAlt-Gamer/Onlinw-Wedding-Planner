package com.wedding.planner.api.v1.dto;

import java.util.Objects;

public record ResponseDTO<T>(T items, Long total, Integer page, Integer perPage, Integer totalPages) {
	public ResponseDTO {
		Objects.requireNonNull(items,"base entity is required for response");
	}
}
