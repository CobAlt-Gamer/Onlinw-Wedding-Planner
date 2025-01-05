package com.wedding.planner.api.v1.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.WeddingDetailsDTO;
import com.wedding.planner.api.v1.service.ApiWeddingDetailsService;
import com.wedding.planner.entity.WeddingDetails;
import com.wedding.planner.repository.WeddingDetailsRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiWeddingDetailsServiceImpl implements ApiWeddingDetailsService {

	@Autowired
	private WeddingDetailsRepository weddingRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<WeddingDetailsDTO>> getweddingDetails(Optional<Long> user) {
		return ResponseEntity.ok(convertToDTO(
				weddingRepo.findByUser(user.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
						: userService.getUser(user.get()).getBody())));
	}

	@Override
	public ResponseEntity<WeddingDetailsDTO> addWeddingDetails(WeddingDetailsDTO weddingDto) {
		WeddingDetails details = WeddingDetails.builder().weddingEventName(weddingDto.weddingEventName())
				.eventDate(LocalDateTime.parse(weddingDto.eventDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")))
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();
		return ResponseEntity.ok(convertToDTO(weddingRepo.save(details)));
	}

	@Override
	public ResponseEntity<WeddingDetailsDTO> updateWeddingDetails(WeddingDetailsDTO weddingDto) {
		Optional<WeddingDetails> dbDetails = weddingRepo.findById(weddingDto.weddingDetailsId());

		if (dbDetails.isPresent()) {
			if (Objects.nonNull(weddingDto.weddingEventName()) && !"".equalsIgnoreCase(weddingDto.weddingEventName())) {
				dbDetails.get().setWeddingEventName(weddingDto.weddingEventName());
			}

			if (Objects.nonNull(weddingDto.eventDate())) {
				dbDetails.get().setEventDate(
						LocalDateTime.parse(weddingDto.eventDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm")));
			}

			if (Objects.nonNull(weddingDto.user())) {
				dbDetails.get().setUser(userService.getUser(utility.getCurrentUsername()).getBody());
			}

			return ResponseEntity.ok(convertToDTO(weddingRepo.save(dbDetails.get())));
		}

		return ResponseEntity.internalServerError().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteweddingDetails(Long weddingDetailsId) {
		try {
			weddingRepo.deleteById(weddingDetailsId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}
}
