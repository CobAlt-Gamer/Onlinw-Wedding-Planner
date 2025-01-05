package com.wedding.planner.api.v1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.wedding.planner.api.v1.dto.ResponseDTO;
import com.wedding.planner.api.v1.dto.ServiceDTO;
import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Services;

public interface ApiServiceService {

	/**
	 * converts Service to ServiceDTO
	 *
	 * @param service
	 * @param serviceImage
	 * @return
	 */
	default ServiceDTO convertToDTO(Services service, String serviceImage) {
		return new ServiceDTO(service.getServiceId(), service.getCreatedBy().getVendorId(), service.getServiceName(),
				service.getServiceDescription(), service.getServiceLocation(), serviceImage);
	}

	/**
	 * Converts List of Service to List of ServiceDTO
	 *
	 * @param services
	 * @param images
	 * @return
	 */
	default List<ServiceDTO> convertToDTO(List<Services> services, List<String> images) {
		return services.stream().map(service -> convertToDTO(service, images.get(services.indexOf(service))))
				.collect(Collectors.toList());
	}

	/**
	 * returns All the available services in {@link ServiceDTO}
	 *
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<ServiceDTO>>> services();

	/**
	 * returns All the available services in {@link ServiceDTO} with pagination
	 *
	 * @param page
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(Pageable page);

	/**
	 * returns All the available services in {@link ServiceDTO} of
	 * {@link ServiceCategories}
	 *
	 * @param category
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(ServiceCategories category);

	/**
	 * returns All the available services in {@link ServiceDTO} of
	 * {@link ServiceCategories} with pagination
	 *
	 * @param category
	 * @param page
	 * @return
	 */
	ResponseEntity<ResponseDTO<List<ServiceDTO>>> services(ServiceCategories category, Pageable page);

	/**
	 * Gets Service By Service id
	 * @param service
	 * @return
	 */
	ResponseEntity<ServiceDTO> service(Long service);

}
