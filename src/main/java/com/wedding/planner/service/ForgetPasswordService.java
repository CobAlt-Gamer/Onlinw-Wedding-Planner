package com.wedding.planner.service;

import org.springframework.http.ResponseEntity;

public interface ForgetPasswordService {

	/**
	 * Send Password Reset Email
	 *
	 * @param email
	 * @return
	 */
	ResponseEntity<String> sendPasswordResetMail(String email);

	/**
	 * Validates that the token is valid or not
	 * @param token
	 * @return
	 */
	ResponseEntity<Boolean> validateResetPasswordToken(String token);

	/**
	 * Resets The User's Password
	 * @param token
	 * @param password
	 * @return
	 */
	ResponseEntity<Boolean> resetPassword(String token,String password);

}
