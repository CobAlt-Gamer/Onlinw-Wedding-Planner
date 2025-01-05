package com.wedding.planner.api.v1.dto;

import com.wedding.planner.enums.ChecklistStatus;

public record ChecklistDTO(Long checklistId, String listItem, String user, ChecklistStatus status) {

}
