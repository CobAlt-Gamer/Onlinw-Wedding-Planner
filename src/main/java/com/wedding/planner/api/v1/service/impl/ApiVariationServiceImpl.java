package com.wedding.planner.api.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.exception.ApiErrorResponse;
import com.wedding.planner.api.exception.ApiException;
import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.VariationDTO;
import com.wedding.planner.api.v1.service.ApiVariationService;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Variation;
import com.wedding.planner.repository.VariationRepository;

@Service
public class ApiVariationServiceImpl implements ApiVariationService {

	@Autowired
	private VariationRepository variationRepo;

	@Override
	@Cacheable(value = "variationCache")
	public ResponseEntity<ResponseDTO<List<VariationDTO>>> variations() {
		List<Variation> variations = variationRepo.findAll();
		if (variations.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = variationRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<VariationDTO>> dto = new ResponseDTO<>(convertToDTO(variations), totalRecords, page, perPage,
				totalPages);
		return ResponseEntity.ok(dto);
	}

	@Override
	@Cacheable(value = "variationCache", key = "#page")
	public ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(Pageable page) {
		List<Variation> variations = variationRepo.findAll(page).toList();
		if (variations.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = variationRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<VariationDTO>> dto = new ResponseDTO<>(convertToDTO(variations), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(dto);
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#category.serviceCategoryId")
	public ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(ServiceCategories category) {
		List<Variation> variations = variationRepo.findByServiceCategory(category);
		if (variations.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = variationRepo.countByServiceCategory(category);
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<VariationDTO>> dto = new ResponseDTO<>(convertToDTO(variations), totalRecords, page, perPage,
				totalPages);
		return ResponseEntity.ok(dto);
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#category.serviceCategoryId")
	public ResponseEntity<ResponseDTO<List<VariationDTO>>> variations(ServiceCategories category, Pageable page) {
		List<Variation> variations = variationRepo.findByServiceCategory(category, page);
		if (variations.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = variationRepo.countByServiceCategory(category);
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<VariationDTO>> dto = new ResponseDTO<>(convertToDTO(variations), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(dto);
	}
}