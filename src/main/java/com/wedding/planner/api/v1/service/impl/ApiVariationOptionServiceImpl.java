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
import com.wedding.planner.api.v1.dto.VariationOptionDTO;
import com.wedding.planner.api.v1.service.ApiVariationOptionService;
import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;
import com.wedding.planner.repository.VariationOptionRepository;

@Service
public class ApiVariationOptionServiceImpl implements ApiVariationOptionService {

	@Autowired
	private VariationOptionRepository optionRepo;

	@Override
	@Cacheable(value = "variationOptionCache")
	public ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions() {
		List<VariationOption> options = optionRepo.findAll();
		if (options.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = optionRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);

		ResponseDTO<List<VariationOptionDTO>> data = new ResponseDTO<>(convertToDTO(options), totalRecords, page,
				perPage, totalPages);

		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "variationOptionCache", key = "#page")
	public ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Pageable page) {
		List<VariationOption> options = optionRepo.findAll(page).toList();
		if (options.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = optionRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());

		ResponseDTO<List<VariationOptionDTO>> data = new ResponseDTO<>(convertToDTO(options), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);

		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "variationCache", key = "#variation.variationId")
	public ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Variation variation) {
		List<VariationOption> options = optionRepo.findByVariation(variation);
		if (options.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = optionRepo.countByVariation(variation);
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);

		ResponseDTO<List<VariationOptionDTO>> data = new ResponseDTO<>(convertToDTO(options), totalRecords, page,
				perPage, totalPages);

		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "variationCache", key = "#variation.variationId")
	public ResponseEntity<ResponseDTO<List<VariationOptionDTO>>> variationOptions(Variation variation, Pageable page) {
		List<VariationOption> options = optionRepo.findByVariation(variation, page);
		if (options.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = optionRepo.countByVariation(variation);
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());

		ResponseDTO<List<VariationOptionDTO>> data = new ResponseDTO<>(convertToDTO(options), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);

		return ResponseEntity.ok(data);
	}

}
