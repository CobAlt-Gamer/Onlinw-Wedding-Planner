package com.wedding.planner.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceItemId;
	private String itemName;
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services service;
	private Double approxPrice;
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "service_item_images", joinColumns = @JoinColumn(name = "service_item_id"), inverseJoinColumns = @JoinColumn(name = "image_id"))
	private List<Images> images;

	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "service_item_variations", joinColumns = @JoinColumn(name = "service_item_id"), inverseJoinColumns = @JoinColumn(name = "variation_option_id"))
	private List<VariationOption> variations;

	private Boolean status;
}
