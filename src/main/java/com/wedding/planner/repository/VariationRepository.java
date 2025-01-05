package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Variation;

public interface VariationRepository extends JpaRepository<Variation, Integer> {

	Long countByServiceCategory(ServiceCategories serviceCategory);

	List<Variation> findByServiceCategory(ServiceCategories serviceCategory);

	List<Variation> findByServiceCategory(ServiceCategories serviceCategory,Pageable page);

}
