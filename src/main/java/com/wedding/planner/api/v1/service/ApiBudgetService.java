package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.BudgetDTO;
import com.wedding.planner.api.v1.dto.ServiceCategoryDTO;
import com.wedding.planner.entity.Budget;
import com.wedding.planner.entity.ServiceCategories;

public interface ApiBudgetService {

	/**
	 * Converts {@link ServiceCategories} to {@link ServiceCategoryDTO}
	 *
	 * @param category
	 * @return {@link ServiceCategoryDTO}
	 */
	default ServiceCategoryDTO convertToDTO(ServiceCategories category) {
		return new ServiceCategoryDTO(category.getServiceCategoryId(), category.getServiceCategoryName(),
				category.getCategoryIcon() != null ? category.getCategoryIcon().getUrl() : null);
	}

	/**
	 * Converts {@link Budget} to {@link BudgetDTO}
	 *
	 * @param budget
	 * @return
	 */
	default BudgetDTO convertToDTO(Budget budget) {
		return new BudgetDTO(budget.getBudgetId(), budget.getExpenceAmount(), convertToDTO(budget.getServiceCetegory()),
				budget.getUser().getUserId().toString());
	}

	/**
	 * Converts {@link List} {@link Budget} to {@link List} {@link BudgetDTO}
	 *
	 * @param budget
	 * @return
	 */
	default List<BudgetDTO> convertToDTO(List<Budget> budget) {
		return budget.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets Available Budget details in {@link List} {@link BudgetDTO}
	 *
	 * @return
	 */
	ResponseEntity<List<BudgetDTO>> getBudget(Optional<Long> user);

	/**
	 * Adds Budget
	 *
	 * @param budgetDto
	 * @return
	 */
	ResponseEntity<BudgetDTO> addBudget(BudgetDTO budgetDto);

	/**
	 * Updates {@link Budget}
	 *
	 * @param budgetDto
	 * @return
	 */
	ResponseEntity<BudgetDTO> updateBudget(BudgetDTO budgetDto);

	/**
	 * Deletes {@link Budget}
	 *
	 * @param budgetId
	 * @return
	 */
	ResponseEntity<Boolean> deleteBudget(Long budgetId);

}
