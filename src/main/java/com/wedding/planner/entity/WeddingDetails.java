package com.wedding.planner.entity;

import java.time.LocalDateTime;

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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class WeddingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long weddingDetailsId;
	private String weddingEventName;
	private LocalDateTime eventDate;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user")
	private Users user;
}