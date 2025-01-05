package com.wedding.planner.api.v1.dto;

import java.util.Objects;

public record ServiceDTO(Long serviceId, Integer createdBy, String serviceName, String serviceDescription,
		String serviceLocation, String serviceImage) {
	public ServiceDTO {
		Objects.requireNonNull(serviceId, "service id require");
		Objects.requireNonNull(createdBy, "required created By");
		Objects.requireNonNull(serviceName, "service NAME require");
		Objects.requireNonNull(serviceDescription, "service DESCRIPTION require");
		Objects.requireNonNull(serviceLocation, "service location require");
	}
}
