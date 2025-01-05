package com.wedding.planner.api.v1.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.BudgetDTO;
import com.wedding.planner.api.v1.service.ApiBudgetService;
import com.wedding.planner.entity.Budget;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.repository.BudgetRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiBudgetServiceImpl implements ApiBudgetService {

	@Autowired
	private BudgetRepository budgetRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<BudgetDTO>> getBudget(Optional<Long> user) {
		return ResponseEntity.ok(convertToDTO(
				budgetRepo.findByUser(user.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
						: userService.getUser(user.get()).getBody())));
	}

	@Override
	public ResponseEntity<BudgetDTO> addBudget(BudgetDTO budgetDto) {
		Budget budget = Budget.builder().expenceAmount(budgetDto.expenceAmount())
				.serviceCetegory(ServiceCategories.builder()
						.serviceCategoryId(budgetDto.serviceCategory().serviceCategoryId()).build())
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();

		return ResponseEntity.ok(convertToDTO(budgetRepo.save(budget)));
	}

	@Override
	public ResponseEntity<BudgetDTO> updateBudget(BudgetDTO budgetDto) {
		Optional<Budget> dbBudget = budgetRepo.findById(budgetDto.budgetId());
		if (dbBudget.isPresent()) {
			if (Objects.nonNull(budgetDto.expenceAmount())) {
				dbBudget.get().setExpenceAmount(budgetDto.expenceAmount());
			}
			if (Objects.nonNull(budgetDto.serviceCategory())) {
				dbBudget.get().setServiceCetegory(ServiceCategories.builder()
						.serviceCategoryId(budgetDto.serviceCategory().serviceCategoryId()).build());
			}
			return ResponseEntity.ok(convertToDTO(budgetRepo.save(dbBudget.get())));
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteBudget(Long budgetId) {
		try {
			budgetRepo.deleteById(budgetId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

}
