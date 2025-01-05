package com.wedding.planner.api.v1.auth;

import java.util.Date;

public record AuthResponse (String token,Date expity) {}