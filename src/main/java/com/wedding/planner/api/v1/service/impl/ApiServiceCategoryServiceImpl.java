package com.wedding.planner.api.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceCategoryDTO;
import com.wedding.planner.api.v1.service.ApiServiceCategoryService;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.repository.ServiceCategoriesRepository;

@Service
public class ApiServiceCategoryServiceImpl implements ApiServiceCategoryService {

	@Autowired
	private ServiceCategoriesRepository categoryRepo;

	@Override
	@Cacheable(value = "categoryCache")
	public ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories() {
		Long totalRecords = categoryRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		return ResponseEntity
				.ok(new ResponseDTO<>(convertToDTO(categoryRepo.findAll()), totalRecords, page, perPage, totalPages));
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#page")
	public ResponseEntity<ResponseDTO<List<ServiceCategoryDTO>>> serviceCategories(Pageable page) {
		Long totalRecords = categoryRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		return ResponseEntity.ok(new ResponseDTO<>(convertToDTO(categoryRepo.findAll(page).toList()), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages));
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#categoryId")
	public final ServiceCategories getServiceCategory(Integer categoryId) {
		try {
			return categoryRepo.findById(categoryId).get();
		} catch (Exception e) {
			return null;
		}
	}

}
