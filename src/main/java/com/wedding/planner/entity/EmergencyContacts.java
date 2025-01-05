package com.wedding.planner.entity;

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
public class EmergencyContacts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	private String contactName;
	private String[] numbers;

	@JoinColumn(name = "status")
	@ManyToOne(fetch = FetchType.EAGER)
	private RelationshipStatus status;

	@JoinColumn(name = "user")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Users user;
}
