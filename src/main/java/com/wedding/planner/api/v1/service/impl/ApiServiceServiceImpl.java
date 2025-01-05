package com.wedding.planner.api.v1.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wedding.planner.api.exception.ApiErrorResponse;
import com.wedding.planner.api.exception.ApiException;
import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceDTO;
import com.wedding.planner.api.v1.service.ApiServiceService;
import com.wedding.planner.config.general.Configurations;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;
import com.wedding.planner.repository.ServiceItemRepository;
import com.wedding.planner.repository.ServicesRepository;

@Service
public class ApiServiceServiceImpl implements ApiServiceService {

	@Autowired
	private ServicesRepository serviceRepo;

	@Autowired
	private ServiceItemRepository serviceItemRepo;

	@Override
	@Cacheable(value = "servicesCache")
	public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services() {
		List<Services> services = serviceRepo.findByStatus(true);
		if (services.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}

		List<String> images = services.parallelStream().map(service -> serviceItemRepo.findRandomByService(service))
				.filter(Optional::isPresent).map(Optional::get).map(item -> item.getImages().get(0).getUrl())
				.collect(Collectors.toList());

		Long totalRecords = serviceRepo.count();
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<ServiceDTO>> res = new ResponseDTO<>(convertToDTO(services, images), totalRecords, page,
				perPage, totalPages);
		return ResponseEntity.ok(res);
	}

	@Override
	@Cacheable(value = "servicesCache", key = "serviceId")
	public ResponseEntity<ServiceDTO> service(Long serviceId) {
		Services service = serviceRepo.findById(serviceId).get();

		String image = Configurations.LOGO_COMPACT;
		Optional<ServiceItem> item = serviceItemRepo.findRandomByService(service);
		if (item.isPresent()) {
			image = item.get().getImages().get(0).getUrl();
		}
		return ResponseEntity.ok(convertToDTO(service, image));
	}

	@Override
	@Cacheable(value = "servicesCache", key = "#page")
	public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(Pageable page) {
		List<Services> services = serviceRepo.findByStatus(true, page);
		if (services.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		List<String> images = services.parallelStream().map(service -> serviceItemRepo.findRandomByService(service))
				.filter(Optional::isPresent).map(Optional::get).map(item -> item.getImages().get(0).getUrl())
				.collect(Collectors.toList());

		Long totalRecords = serviceRepo.count();
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<ServiceDTO>> res = new ResponseDTO<>(convertToDTO(services, images), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(res);
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#category.serviceCategoryId")
	public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(ServiceCategories category) {
		List<Services> services = serviceRepo.findByServicecategoryAndStatus(category, true);
		if (services.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		List<String> images = services.parallelStream().map(service -> serviceItemRepo.findRandomByService(service))
				.filter(Optional::isPresent).map(Optional::get).map(item -> item.getImages().get(0).getUrl())
				.collect(Collectors.toList());

		Long totalRecords = serviceRepo.countByServicecategory(category);
		Integer page = 0;
		Integer perPage = 10;
		Integer totalPages = (int) Math.ceil((double) totalRecords / perPage);
		ResponseDTO<List<ServiceDTO>> res = new ResponseDTO<>(convertToDTO(services, images), totalRecords, page,
				perPage, totalPages);
		return ResponseEntity.ok(res);
	}

	@Override
	@Cacheable(value = "categoryCache", key = "#category.serviceCategoryId")
	public ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(ServiceCategories category, Pageable page) {
		List<Services> services = serviceRepo.findByServicecategoryAndStatus(category, true, page);
		if (services.isEmpty()) {
			throw new ApiException(new ApiErrorResponse("", HttpStatus.NO_CONTENT));
		}
		List<String> images = services.parallelStream().map(service -> serviceItemRepo.findRandomByService(service))
				.filter(Optional::isPresent).map(Optional::get).map(item -> item.getImages().get(0).getUrl())
				.collect(Collectors.toList());

		Long totalRecords = serviceRepo.countByServicecategory(category);
		Integer totalPages = (int) Math.ceil((double) totalRecords / page.getPageSize());
		ResponseDTO<List<ServiceDTO>> res = new ResponseDTO<>(convertToDTO(services, images), totalRecords,
				page.getPageNumber(), page.getPageSize(), totalPages);
		return ResponseEntity.ok(res);
	}
}
