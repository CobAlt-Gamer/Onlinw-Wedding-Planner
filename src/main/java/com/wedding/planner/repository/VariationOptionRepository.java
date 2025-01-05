package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.Variation;
import com.wedding.planner.entity.VariationOption;

public interface VariationOptionRepository extends JpaRepository<VariationOption, Integer> {

	Long countByVariation(Variation variation);

	List<VariationOption> findByVariation(Variation variation);

	List<VariationOption> findByVariation(Variation variation, Pageable page);
}
