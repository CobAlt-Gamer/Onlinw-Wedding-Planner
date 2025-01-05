package com.wedding.planner.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Inspiration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long inspirationId;

	@JoinColumn(name = "posted_by")
	@ManyToOne(cascade = CascadeType.MERGE)
	private Users postedBy;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "image")
	private Images image;
	private String description;
	private String[] tags;
}
