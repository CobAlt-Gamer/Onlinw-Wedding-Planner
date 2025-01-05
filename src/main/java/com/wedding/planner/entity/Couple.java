package com.wedding.planner.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class Couple {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coupleId;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "bride")
	private Users bride;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "groom")
	private Users groom;
}
