package com.wedding.planner.api.exception;

public class ApiException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final ApiErrorResponse errorResponse;

	public ApiException(ApiErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

	public ApiErrorResponse getErrorResponse() {
		return errorResponse;
	}

}
