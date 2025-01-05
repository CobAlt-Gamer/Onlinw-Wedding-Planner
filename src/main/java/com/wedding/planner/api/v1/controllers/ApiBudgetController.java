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

import com.wedding.planner.api.v1.dto.BudgetDTO;
import com.wedding.planner.api.v1.service.ApiBudgetService;

@RestController
@RequestMapping("/api/v1/budget")
public class ApiBudgetController {

	@Autowired
	private ApiBudgetService budgetService;

	@GetMapping
	ResponseEntity<List<BudgetDTO>> getBudget(@RequestParam(name = "user", required = false) Long user) {
		return budgetService.getBudget(user != null ? Optional.of(user) : Optional.empty());
	}

	@PostMapping
	ResponseEntity<BudgetDTO> addBudget(@RequestBody BudgetDTO budget) {
		return budgetService.addBudget(budget);
	}

	@PutMapping
	ResponseEntity<BudgetDTO> updateBudget(@RequestBody BudgetDTO budget) {
		return budgetService.updateBudget(budget);
	}

	@DeleteMapping("{budget}")
	ResponseEntity<Boolean> deleteBudget(@PathVariable("budget") Long budgetId) {
		return budgetService.deleteBudget(budgetId);
	}

}
