package com.wedding.planner.api.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice(basePackages = "com.wedding.planner.api")
public class ApiExceptionHandler{

//    @ExceptionHandler(AccessDeniedException.class)
//    public ResponseEntity<ApiErrorResponse> handleAccessDeniedException(AccessDeniedException ex) {
//        // Handle access denied exception
//        return new ResponseEntity<ApiErrorResponse>(new ApiErrorResponse(ex.getMessage(),HttpStatus.UNAUTHORIZED),HttpStatus.UNAUTHORIZED);
//    }


	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<ApiErrorResponse> handleApiException(NoResourceFoundException ex) {
		return new ResponseEntity<>(new ApiErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND), ex.getStatusCode());
	}

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiErrorResponse> handleApiException(ApiException ex) {
		return new ResponseEntity<>(ex.getErrorResponse(), ex.getErrorResponse().status());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericException(Exception ex) {
		// Handle generic exceptions
		return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}