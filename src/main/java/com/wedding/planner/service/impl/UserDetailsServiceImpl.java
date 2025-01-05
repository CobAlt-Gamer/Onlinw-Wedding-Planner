package com.wedding.planner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wedding.planner.config.auth.AuthUserDetails;
import com.wedding.planner.entity.Users;
import com.wedding.planner.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userService.getUser(username).getBody();

		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username Or Password");
		}

		return new AuthUserDetails(user);
	}
}
