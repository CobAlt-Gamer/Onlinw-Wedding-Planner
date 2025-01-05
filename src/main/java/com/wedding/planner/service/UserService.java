package com.wedding.planner.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.entity.Images;
import com.wedding.planner.entity.Users;
import com.wedding.planner.enums.UserRole;

public interface UserService {

	/**
	 * Adds user into database
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<Users> addUser(Users user);

	/**
	 * updates old user to provided user
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<Users> updateUser(Users user);

	/**
	 * Updates User Status
	 * @param status
	 * @return
	 */
	ResponseEntity<Users> updateUserStatus(Long userId,Boolean status);

	/**
	 * gets the Users list
	 *
	 * @return
	 */
	ResponseEntity<List<Users>> getUsers();

	/**
	 * Gets Users By Role
	 *
	 * @param role
	 * @return
	 */
	ResponseEntity<List<Users>> getUsers(UserRole role);

	/**
	 * Searches for users
	 * @param role
	 * @param search
	 * @return
	 */
	ResponseEntity<List<Users>> getUsers(UserRole role, String search);

	/**
	 * updates the login status for user
	 *
	 * @param email
	 * @param status
	 * @return
	 */
	ResponseEntity<Boolean> updateLoginStatus(String email, Boolean status);

	/**
	 * Gets the user by email
	 *
	 * @param email
	 * @return
	 */
	ResponseEntity<Users> getUser(String email);

	/**
	 * Gets User By UserId
	 *
	 * @param userId
	 * @return
	 */
	ResponseEntity<Users> getUser(Long userId);

	/**
	 * Deletes given User
	 *
	 * @param user
	 * @return
	 */
	ResponseEntity<Boolean> deleteUser(Users user);

	/**
	 * updates user's avatar
	 *
	 * @param email
	 * @param file
	 * @return
	 */
	ResponseEntity<String> updateAvatar(String email, MultipartFile file);

	/**
	 * updates user's avatar
	 *
	 * @param email
	 * @param file
	 * @return
	 */
	ResponseEntity<Images> updateAvatarImage(String email, MultipartFile file);

	/**
	 * Updates User password
	 * @param email
	 * @param password
	 * @return
	 */
	ResponseEntity<Boolean> updatePassword(String email,String password);

	/**
	 * Gets users count by {@link UserRole}
	 * @param role
	 * @return
	 */
	Long getUsersCount(UserRole role);

	/**
	 * Gets User Count by {@link UserRole} and {@link LocalDate}
	 * @param role
	 * @param createdAt
	 * @return
	 */
	Integer getUserCount(UserRole role,LocalDateTime createdAt);
}
