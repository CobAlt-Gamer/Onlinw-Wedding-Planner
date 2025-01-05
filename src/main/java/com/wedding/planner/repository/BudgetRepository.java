package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Budget;
import com.wedding.planner.entity.Users;


public interface BudgetRepository extends JpaRepository<Budget, Long>{

	List<Budget> findByUser(Users user);
}
