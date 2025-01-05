package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Checklist;
import com.wedding.planner.entity.Users;

public interface ChecklistRepository extends JpaRepository<Checklist, Long>{

	List<Checklist> findByUser(Users user);

}
