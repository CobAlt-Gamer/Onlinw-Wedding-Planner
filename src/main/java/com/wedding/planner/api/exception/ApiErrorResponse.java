package com.wedding.planner.api.exception;

import java.util.Objects;

import org.springframework.http.HttpStatus;

public record ApiErrorResponse(String meaasge, HttpStatus status) {
	public ApiErrorResponse {
		Objects.requireNonNull(status,"status is required");
	}

}
