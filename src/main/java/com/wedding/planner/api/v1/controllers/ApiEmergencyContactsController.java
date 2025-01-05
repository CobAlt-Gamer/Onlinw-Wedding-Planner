package com.wedding.planner.api.v1.controllers;

import java.util.List;
import java.util.Optional;

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

import com.wedding.planner.api.v1.dto.EmergencyContactsDTO;
import com.wedding.planner.api.v1.service.ApiEmergencyContactsService;

@RestController
@RequestMapping("/api/v1/contact")
public class ApiEmergencyContactsController {

	@Autowired
	private ApiEmergencyContactsService emergencyService;

	@GetMapping
	ResponseEntity<List<EmergencyContactsDTO>> getContacts(@RequestParam(name="user",required = false) Long user) {
		return emergencyService.getContacts(user!=null?Optional.of(user):Optional.empty());
	}

	@PostMapping
	ResponseEntity<EmergencyContactsDTO> addContact(@RequestBody EmergencyContactsDTO contact) {
		return emergencyService.addContact(contact);
	}

	@PutMapping
	ResponseEntity<EmergencyContactsDTO> updateContact(@RequestBody EmergencyContactsDTO contact) {
		return emergencyService.updateContact(contact);
	}

	@DeleteMapping("{contact}")
	ResponseEntity<Boolean> deleteContact(@PathVariable("contact") Long contactId) {
		return emergencyService.deleteContact(contactId);
	}

}
