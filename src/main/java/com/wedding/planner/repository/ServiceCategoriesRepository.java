package com.wedding.planner.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.ServiceCategories;

public interface ServiceCategoriesRepository extends JpaRepository<ServiceCategories, Integer> {

}
