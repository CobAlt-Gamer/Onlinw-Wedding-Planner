package com.wedding.planner.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.entity.EmergencyContacts;
import com.wedding.planner.entity.Users;

public interface EmergencyContactsService {

	/**
	 * Gets All the {@link EmergencyContacts}
	 * @param user
	 * @return
	 */
	ResponseEntity<List<EmergencyContacts>> getcontacts(Users user);

	/**
	 * Adds {@link EmergencyContacts}
	 * @param contact
	 * @return
	 */
	ResponseEntity<EmergencyContacts> addContact(EmergencyContacts contact);

	/**
	 * Updates {@link EmergencyContacts}
	 * @param contact
	 * @return
	 */
	ResponseEntity<EmergencyContacts> updateContact(EmergencyContacts contact);

	/**
	 * Deletes {@link EmergencyContacts}
	 * @param contact
	 * @return
	 */
	ResponseEntity<Boolean> deleteContact(EmergencyContacts contact);

	/**
	 * Deletes Contact By Id
	 * @param contactId
	 * @return
	 */
	ResponseEntity<Boolean> deleteContact(Long contactId);
}
