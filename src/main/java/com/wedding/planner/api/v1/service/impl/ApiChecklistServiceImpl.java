package com.wedding.planner.api.v1.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.ChecklistDTO;
import com.wedding.planner.api.v1.service.ApiChecklistService;
import com.wedding.planner.entity.Checklist;
import com.wedding.planner.entity.Users;
import com.wedding.planner.repository.ChecklistRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiChecklistServiceImpl implements ApiChecklistService {

	@Autowired
	private ChecklistRepository checklistRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<ChecklistDTO> addChecklist(ChecklistDTO checklistDto) {
		Checklist checklist = Checklist.builder().listItem(checklistDto.listItem()).status(checklistDto.status())
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();

		return ResponseEntity.ok(convertToDTO(checklistRepo.save(checklist)));
	}

	@Override
	public ResponseEntity<ChecklistDTO> updateChecklist(ChecklistDTO checklistDto) {

		Optional<Checklist> dbChecklist = checklistRepo.findById(checklistDto.checklistId());

		if (dbChecklist.isPresent()) {

			if (Objects.nonNull(checklistDto.listItem()) && !"".equalsIgnoreCase(checklistDto.listItem())) {
				dbChecklist.get().setListItem(checklistDto.listItem());
			}

			if (Objects.nonNull(checklistDto.status())) {
				dbChecklist.get().setStatus(checklistDto.status());
			}

			return ResponseEntity.ok(convertToDTO(checklistRepo.save(dbChecklist.get())));
		}

		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity<List<ChecklistDTO>> getChecklists(Optional<Long> userId) {
		Users user = userId.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
				: userService.getUser(userId.get()).getBody();
		return ResponseEntity.ok(convertToDTO(checklistRepo.findByUser(user)));
	}

	@Override
	public ResponseEntity<Boolean> deleteChecklist(Long checklistId) {
		try {
			checklistRepo.deleteById(checklistId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

}
