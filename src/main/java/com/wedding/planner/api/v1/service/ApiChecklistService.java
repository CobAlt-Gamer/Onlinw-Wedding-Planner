package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ChecklistDTO;
import com.wedding.planner.entity.Checklist;

public interface ApiChecklistService {

	/**
	 * Converts {@link Checklist} to {@link ChecklistDTO}
	 * @param checklist
	 * @return
	 */
	default ChecklistDTO convertToDTO(Checklist checklist) {
		return new ChecklistDTO(checklist.getChecklistId(), checklist.getListItem(),
				checklist.getUser().getUserId().toString(), checklist.getStatus());
	}

	/**
	 * Converts {@link List} {@link Checklist} to {@link List} {@link ChecklistDTO}
	 * @param checklists
	 * @return
	 */
	default List<ChecklistDTO> convertToDTO(List<Checklist> checklists) {
		return checklists.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Adds {@link Checklist} Item
	 * @param checklist
	 * @return
	 */
	ResponseEntity<ChecklistDTO> addChecklist(ChecklistDTO checklist);

	/**
	 * Updates {@link Checklist} Item
	 * @param checklist
	 * @return
	 */
	ResponseEntity<ChecklistDTO> updateChecklist(ChecklistDTO checklist);

	/**
	 * Gets {@link List} of {@link ChecklistDTO}
	 * @return
	 */
	ResponseEntity<List<ChecklistDTO>> getChecklists(Optional<Long> user);

	/**
	 * Deletes {@link Checklist} by Given Id
	 * @param checklistId
	 * @return
	 */
	ResponseEntity<Boolean> deleteChecklist(Long checklistId);

}
