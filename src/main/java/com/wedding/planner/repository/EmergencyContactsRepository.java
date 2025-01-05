package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.EmergencyContacts;
import com.wedding.planner.entity.Users;

public interface EmergencyContactsRepository extends JpaRepository<EmergencyContacts, Long>{

	List<EmergencyContacts> findByUser(Users user);

}
