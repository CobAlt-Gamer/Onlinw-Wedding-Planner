package com.wedding.planner.entity;

import com.wedding.planner.enums.ChecklistStatus;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Checklist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long checklistId;

	private String listItem;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user")
	private Users user;

	private ChecklistStatus status;
}
