package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.EmergencyContactsDTO;
import com.wedding.planner.entity.EmergencyContacts;

public interface ApiEmergencyContactsService {

	/**
	 * Converts {@link EmergencyContacts} to {@link EmergencyContactsDTO}
	 * @param contact
	 * @return
	 */
	default EmergencyContactsDTO convertToDTO(EmergencyContacts contact) {
		return new EmergencyContactsDTO(contact.getContactId(), contact.getContactName(), contact.getNumbers(),
				contact.getStatus().getRelationshipName(), contact.getUser().getUserId());
	}

	/**
	 * Converts {@link List} {@link EmergencyContacts} of {@link List} {@link EmergencyContactsDTO}
	 * @param contacts
	 * @return
	 */
	default List<EmergencyContactsDTO> convertToDTO(List<EmergencyContacts> contacts){
		return contacts.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * gets {@link List} {@link EmergencyContactsDTO}
	 * @param user
	 * @return
	 */
	ResponseEntity<List<EmergencyContactsDTO>> getContacts(Optional<Long> user);

	/**
	 * adds {@link EmergencyContactsDTO}
	 * @param contact
	 * @return
	 */
	ResponseEntity<EmergencyContactsDTO> addContact(EmergencyContactsDTO contact);

	/**
	 * Updates {@link EmergencyContacts} and returns updated {@link EmergencyContactsDTO}
	 * @param contact
	 * @return
	 */
	ResponseEntity<EmergencyContactsDTO> updateContact(EmergencyContactsDTO contact);

	/**
	 * Deletes {@link EmergencyContacts}
	 * @param contactId
	 * @return
	 */
	ResponseEntity<Boolean> deleteContact(Long contactId);

}
