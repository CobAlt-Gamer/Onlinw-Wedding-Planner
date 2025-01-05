package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.InquiryDTO;
import com.wedding.planner.entity.Inquiry;

public interface ApiInquiryService {

	/**
	 * Converts {@link Inquiry} to {@link InquiryDTO}
	 * @param inquiry
	 * @return
	 */
	default InquiryDTO convertToDTO(Inquiry inquiry) {
		return new InquiryDTO(inquiry.getInquiryId(), inquiry.getDescription(),
				inquiry.getServiceItem().getServiceItemId().toString(), inquiry.getUser().getUserId().toString());
	}

	/**
	 * Converts {@link List} of {@link Inquiry} to {@link List} of {@link InquiryDTO}
	 * @param inquiries
	 * @return
	 */
	default List<InquiryDTO> convertToDTO(List<Inquiry> inquiries) {
		return inquiries.stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	/**
	 * Gets All the Inquiries
	 * @return
	 */
	ResponseEntity<List<InquiryDTO>> getInquiries(Optional<Long> userId);

	/**
	 * Adds Inquiry
	 * @param inquiryDto
	 * @return
	 */
	ResponseEntity<InquiryDTO> addInquiry(InquiryDTO inquiryDto);

	/**
	 * Updates Inquiry
	 * @param inquiryDto
	 * @return
	 */
	ResponseEntity<InquiryDTO> updateInquiry(InquiryDTO inquiryDto);

	/**
	 * Deletes Inquiry
	 * @param inquiryId
	 * @return
	 */
	ResponseEntity<Boolean> deleteInquiry(Long inquiryId);

}
