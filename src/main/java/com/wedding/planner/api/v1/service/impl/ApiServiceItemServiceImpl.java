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
import com.wedding.planner.api.v1.dto.ServiceItemDTO;
import com.wedding.planner.api.v1.service.ApiServiceItemService;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;
import com.wedding.planner.repository.ServiceItemRepository;

@Service
public class ApiServiceItemServiceImpl implements ApiServiceItemService {

	@Autowired
	private ServiceItemRepository serviceItemRepo;

	@Override
	@Cacheable(value = "itemsCache")
	public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems() {
		List<ServiceItem> items = serviceItemRepo.findByStatus(true);
		if (items.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = serviceItemRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<ServiceItemDTO>> data = new ResponseDTO<>(convertToDTO(items), totalRecords, page, perPage,
				totalPages);
		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "itemsCache", key = "#item")
	public ResponseEntity<ServiceItemDTO> serviceItem(Long item) {
		return ResponseEntity.ok(convertToDTO(serviceItemRepo.findById(item).get()));
	}

	@Override
	@Cacheable(value = "itemsCache", key = "#page")
	public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Pageable page) {
		List<ServiceItem> items = serviceItemRepo.findByStatus(true, page);
		if (items.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = serviceItemRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<ServiceItemDTO>> data = new ResponseDTO<>(convertToDTO(items), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "servicesCache", key = "#service.serviceId")
	public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Services service) {
		List<ServiceItem> items = serviceItemRepo.findByServiceAndStatus(service, true);
		if (items.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = serviceItemRepo.countByService(service);
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<ServiceItemDTO>> data = new ResponseDTO<>(convertToDTO(items), totalRecords, page, perPage,
				totalPages);
		return ResponseEntity.ok(data);
	}

	@Override
	@Cacheable(value = "servicesCache", key = "#service.serviceId")
	public ResponseEntity<ResponseDTO<List<ServiceItemDTO>>> serviceItems(Services service, Pageable page) {
		List<ServiceItem> items = serviceItemRepo.findByServiceAndStatus(service, true, page);
		if (items.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		Long totalRecords = serviceItemRepo.countByService(service);
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<ServiceItemDTO>> data = new ResponseDTO<>(convertToDTO(items), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(data);
	}

}
