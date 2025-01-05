package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Users;
import com.wedding.planner.entity.WeddingDetails;

public interface WeddingDetailsRepository extends JpaRepository<WeddingDetails, Long> {

	List<WeddingDetails> findByUser(Users user);

}
