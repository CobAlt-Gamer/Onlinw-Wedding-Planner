package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Inquiry;
import com.wedding.planner.entity.Users;


public interface InquiryRepository extends JpaRepository<Inquiry, Long>{

	List<Inquiry> findByUser(Users user);

}
