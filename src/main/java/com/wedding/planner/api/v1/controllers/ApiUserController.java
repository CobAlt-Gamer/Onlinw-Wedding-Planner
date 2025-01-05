package com.wedding.planner.api.v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.auth.SignUpRequest;
import com.wedding.planner.api.v1.dto.CoupleDTO;
import com.wedding.planner.api.v1.dto.ImageDTO;
import com.wedding.planner.api.v1.dto.UserDTO;
import com.wedding.planner.api.v1.service.ApiUserService;

@RestController
@RequestMapping("/api/v1/user")
public class ApiUserController {

	@Autowired
	private ApiUserService userService;

	@PostMapping("/couple")
	public ResponseEntity<CoupleDTO> addCouple(@RequestBody SignUpRequest request) {
		return userService.registerUser(request);
	}

	@PostMapping("/couple/{email}")
	public ResponseEntity<CoupleDTO> addCouple(@PathVariable("email") String email){
		return userService.addCouple(email);
	}

	@GetMapping("/couple")
	public ResponseEntity<CoupleDTO> getCouple() {
		return userService.getCouple();
	}

	@GetMapping("/current")
	public ResponseEntity<UserDTO> getUser() {
		return userService.getUser();
	}

	@GetMapping("{user}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("user") Long userId) {
		return userService.getUser(userId);
	}

	@PutMapping("/update")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
		return userService.updateUser(user);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteUser() {
		return userService.deleteUser();
	}

	@PostMapping("/avatar")
	public ResponseEntity<ImageDTO> avatar(@RequestParam("file") MultipartFile image) {
		return userService.updateAvatar(image);
	}
}