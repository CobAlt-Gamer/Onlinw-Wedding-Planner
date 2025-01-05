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

import com.wedding.planner.api.v1.dto.ChecklistDTO;
import com.wedding.planner.api.v1.service.ApiChecklistService;

@RestController
@RequestMapping("/api/v1/checklist")
public class ApiChecklistController {

	@Autowired
	private ApiChecklistService checklistService;

	@GetMapping
	public ResponseEntity<List<ChecklistDTO>> getChecklists(@RequestParam(name = "user", required = false) Long user) {
		return checklistService.getChecklists(user != null ? Optional.of(user) : Optional.empty());
	}

	@PostMapping
	public ResponseEntity<ChecklistDTO> addChecklist(@RequestBody ChecklistDTO checklist) {
		return checklistService.addChecklist(checklist);
	}

	@PutMapping
	public ResponseEntity<ChecklistDTO> updatechecklist(@RequestBody ChecklistDTO checklist) {
		return checklistService.updateChecklist(checklist);
	}

	@DeleteMapping("{checklist}")
	public ResponseEntity<Boolean> deleteChecklist(@PathVariable("checklist") Long checklist) {
		return checklistService.deleteChecklist(checklist);
	}

}
