package com.wedding.planner.api.v1.dto;

public record BudgetDTO(Long budgetId, Double expenceAmount, ServiceCategoryDTO serviceCategory, String user) {

}
