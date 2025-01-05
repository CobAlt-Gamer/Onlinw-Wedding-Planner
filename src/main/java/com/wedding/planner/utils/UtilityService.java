package com.wedding.planner.utils;

public interface UtilityService {
	/**
	 * gets the current username of logged in user
	 *
	 * @return
	 */
	String getCurrentUsername();

	/**
	 * invalidates the session for given username
	 *
	 * @param username
	 */
	void invalidateUserSession(String username);
}
