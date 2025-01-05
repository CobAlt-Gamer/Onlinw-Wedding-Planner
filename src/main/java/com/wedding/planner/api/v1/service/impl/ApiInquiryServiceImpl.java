package com.wedding.planner.api.v1.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.InquiryDTO;
import com.wedding.planner.api.v1.service.ApiInquiryService;
import com.wedding.planner.entity.Inquiry;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.repository.InquiryRepository;
import com.wedding.planner.service.UserService;
import com.wedding.planner.utils.UtilityService;

@Service
public class ApiInquiryServiceImpl implements ApiInquiryService {

	@Autowired
	private InquiryRepository inquiryRepo;

	@Autowired
	private UserService userService;

	@Autowired
	private UtilityService utility;

	@Override
	public ResponseEntity<List<InquiryDTO>> getInquiries(Optional<Long> user) {
		return ResponseEntity.ok(convertToDTO(
				inquiryRepo.findByUser(user.isEmpty() ? userService.getUser(utility.getCurrentUsername()).getBody()
						: userService.getUser(user.get()).getBody())));
	}

	@Override
	public ResponseEntity<InquiryDTO> addInquiry(InquiryDTO inquiryDto) {
		Inquiry inquiry = Inquiry.builder().description(inquiryDto.description())
				.serviceItem(ServiceItem.builder().serviceItemId(Long.parseLong(inquiryDto.serviceItem())).build())
				.user(userService.getUser(utility.getCurrentUsername()).getBody()).build();

		return ResponseEntity.ok(convertToDTO(inquiryRepo.save(inquiry)));
	}

	@Override
	public ResponseEntity<InquiryDTO> updateInquiry(InquiryDTO inquiryDto) {
		Optional<Inquiry> dbInquiry = inquiryRepo.findById(inquiryDto.inquiryId());
		if (dbInquiry.isPresent()) {
			if (Objects.nonNull(inquiryDto.description()) && !"".equalsIgnoreCase(inquiryDto.description())) {
				dbInquiry.get().setDescription(inquiryDto.description());
			}
			return ResponseEntity.ok(convertToDTO(inquiryRepo.save(dbInquiry.get())));
		}

		return ResponseEntity.internalServerError().build();
	}

	@Override
	public ResponseEntity<Boolean> deleteInquiry(Long inquiryId) {
		try {
			inquiryRepo.deleteById(inquiryId);
			return ResponseEntity.ok(true);
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body(false);
		}
	}

}
