package com.wedding.planner.api.v1.auth;

import com.wedding.planner.enums.CoupleRole;

public record SignUpRequest(String firstName, String lastName, String email, String password, CoupleRole couple,
		String user) {

}