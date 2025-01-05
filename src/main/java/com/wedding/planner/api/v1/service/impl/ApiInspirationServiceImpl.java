package com.wedding.planner.api.v1.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wedding.planner.api.v1.dto.InspirationDTO;
import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.service.ApiInspirationService;
import com.wedding.planner.entity.Images;
import com.wedding.planner.entity.Inspiration;
import com.wedding.planner.entity.Users;
import com.wedding.planner.repository.InspirationRepository;
import com.wedding.planner.service.StorageService;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;
import com.wedding.planner.utils.impl.Storage;

@Service
public class ApiInspirationServiceImpl implements ApiInspirationService {

	@Autowired
	private InspirationRepository inspirationRepo;

	@Autowired
	private StorageService storage;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<InspirationDTO> addInspiration(MultipartFile file, String description, String[] tags) {
		try {
			Images image = storage.upload(file, file.getName(), Storage.STORAGE_INSPIRATIONS);
			Users user = userService.getUser(utility.getCurrentUsername()).getBody();
			Inspiration inspiration = Inspiration.builder().postedBy(user).description(description).tags(tags)
					.image(image).build();
			return ResponseEntity.ok(convertToDTO(inspirationRepo.save(inspiration)));
		} catch (IOException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<InspirationDTO> updateInspiration(Long inspirationId, MultipartFile file, String description,
			String[] tags) {
		try {
			Inspiration inspiration = inspirationRepo.findById(inspirationId).get();
			if (Objects.nonNull(file)) {
				inspiration.setImage(storage.upload(file, file.getName(), Storage.STORAGE_INSPIRATIONS, inspiration.getImage().getImageId()));
			}

			if (Objects.nonNull(description)) {
				inspiration.setDescription(description);
			}

			if (Objects.nonNull(tags) && tags.length != 0) {
				inspiration.setTags(tags);
			}

			return ResponseEntity.ok(convertToDTO(inspirationRepo.save(inspiration)));

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Override
	public ResponseEntity<InspirationDTO> getInspiration(Long inspirationId) {
		Inspiration inspiration = inspirationRepo.findById(inspirationId).get();
		return ResponseEntity.ok(convertToDTO(inspiration));
	}

	@Override
	public ResponseEntity<Boolean> deleteInspiration(Long inspirationId) {
		try {
			Inspiration inspiration = inspirationRepo.findById(inspirationId).get();
			storage.delete(inspiration.getImage());

			inspirationRepo.delete(inspiration);

			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public ResponseEntity<ResponseDTO<List<InspirationDTO>>> getAllInspirations(Integer page, Integer perPage) {
		Long totalRecords = inspirationRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		return ResponseEntity.ok(new ResponseDTO<>(convertToDTO(inspirationRepo.findAll(PageRequest.of(page, perPage)).toList()),
				totalRecords, page, perPage, totalPages));
	}

	@Override
	public ResponseEntity<ResponseDTO<List<InspirationDTO>>> getAllInspirations() {
		Long totalRecords = inspirationRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		return ResponseEntity.ok(
				new ResponseDTO<>(convertToDTO(inspirationRepo.findAll()), totalRecords, page, perPage, totalPages));
	}
}
