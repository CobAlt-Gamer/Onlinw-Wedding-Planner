package com.wedding.planner.api.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.EmergencyContactsDTO;
import com.wedding.planner.api.v1.service.ApiEmergencyContactsService;
import com.wedding.planner.entity.EmergencyContacts;
import com.wedding.planner.service.EmergencyContactsService;
import com.wedding.planner.service.RelationshipStatusService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiEmergencyContactsServiceImpl implements ApiEmergencyContactsService {

	@Autowired
	private EmergencyContactsService contactService;

	@Autowired
	private RelationshipStatusService statusService;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<EmergencyContactsDTO>> getContacts(Optional<Long> user) {
		return ResponseEntity.ok(convertToDTO(
				contactService.getcontacts(user.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
						: userService.getUser(user.get()).getBody()).getBody()));
	}

	@Override
	public ResponseEntity<EmergencyContactsDTO> addContact(EmergencyContactsDTO contactDto) {

		EmergencyContacts contact = EmergencyContacts.builder().contactName(contactDto.contactName())
				.numbers(contactDto.numbers()).status(statusService.getStatus(contactDto.status()).getBody())
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();

		return ResponseEntity.ok(convertToDTO(contactService.addContact(contact).getBody()));
	}

	@Override
	public ResponseEntity<EmergencyContactsDTO> updateContact(EmergencyContactsDTO contactDto) {
		EmergencyContacts contact = EmergencyContacts.builder().contactId(contactDto.contactId())
				.contactName(contactDto.contactName()).numbers(contactDto.numbers())
				.status(statusService.getStatus(contactDto.status()).getBody())
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();
		return ResponseEntity.ok(convertToDTO(contactService.updateContact(contact).getBody()));

	}

	@Override
	public ResponseEntity<Boolean> deleteContact(Long contactId) {
		return contactService.deleteContact(contactId);
	}

}
