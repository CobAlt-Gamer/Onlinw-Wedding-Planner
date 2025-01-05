package com.wedding.planner.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private Double bookingPrice;
	private LocalDateTime eventDate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "booked_service")
	private ServiceItem bookedService;

	@JoinColumn(name = "booked_by")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Users bookedBy;

	@CreationTimestamp
	private LocalDateTime bookedAt;
}
