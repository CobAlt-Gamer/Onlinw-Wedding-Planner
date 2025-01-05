package com.wedding.planner.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.entity.EmergencyContacts;
import com.wedding.planner.entity.Users;
import com.wedding.planner.repository.EmergencyContactsRepository;
import com.wedding.planner.service.EmergencyContactsService;

@Service
public class EmergencyContactsServiceImpl implements EmergencyContactsService {

	@Autowired
	private EmergencyContactsRepository contactsRepo;

	@Override
	public ResponseEntity<List<EmergencyContacts>> getcontacts(Users user) {
		return ResponseEntity.ok(contactsRepo.findByUser(user));
	}

	@Override
	public ResponseEntity<EmergencyContacts> addContact(EmergencyContacts contact) {
		return ResponseEntity.ok(contactsRepo.save(contact));
	}

	@Override
	public ResponseEntity<EmergencyContacts> updateContact(EmergencyContacts contact) {
		Optional<EmergencyContacts> dbContact = contactsRepo.findById(contact.getContactId());
		if (dbContact.isPresent()) {
			if (Objects.nonNull(contact.getContactName()) && !"".equalsIgnoreCase(contact.getContactName())) {
				dbContact.get().setContactName(contact.getContactName());
			}

			if (Objects.nonNull(contact.getNumbers())) {
				dbContact.get().setNumbers(contact.getNumbers());
			}

			if (Objects.nonNull(contact.getStatus())) {
				dbContact.get().setStatus(contact.getStatus());
			}

			return ResponseEntity.ok(contactsRepo.save(dbContact.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteContact(EmergencyContacts contact) {
		try {
			contactsRepo.delete(contact);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

	@Override
	public ResponseEntity<Boolean> deleteContact(Long contactId) {
		try {
			contactsRepo.deleteById(contactId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}
}
