package com.wedding.planner.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Inquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inquiryId;
	private String description;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "service_item")
	private ServiceItem serviceItem;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private Users user;
}
