package com.wedding.planner.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wedding.planner.entity.ServiceCategories;
import com.wedding.planner.entity.Services;
import com.wedding.planner.entity.Vendor;

public interface ServicesRepository extends JpaRepository<Services, Long> {

	Long countByServicecategory(ServiceCategories servicecategory);

    List<Services> findByStatus(Boolean status);

    List<Services> findByStatus(Boolean status, Pageable page);

    List<Services> findByServicecategory(ServiceCategories servicecategory);

    List<Services> findByServicecategoryAndStatus(ServiceCategories servicecategory, Boolean status);

    List<Services> findByServicecategory(ServiceCategories servicecategory, Pageable page);

    List<Services> findByServicecategoryAndStatus(ServiceCategories servicecategory, Boolean status, Pageable page);

    Long countByServicecategoryAndCreatedBy(ServiceCategories servicecategory,Vendor vendor);

    List<Services> findByStatusAndCreatedBy(Boolean status,Vendor vendor);

    List<Services> findByStatusAndCreatedBy(Boolean status, Vendor vendor,Pageable page);

    List<Services> findByServicecategoryAndCreatedBy(ServiceCategories servicecategory,Vendor vendor);

    List<Services> findByServicecategoryAndStatusAndCreatedBy(ServiceCategories servicecategory, Boolean status,Vendor vendor);

    List<Services> findByServicecategoryAndCreatedBy(ServiceCategories servicecategory, Vendor vendor,Pageable page);

    List<Services> findByServicecategoryAndStatusAndCreatedBy(ServiceCategories servicecategory, Boolean status, Vendor vendor,Pageable page);

    List<Services> findByCreatedBy(Vendor createdBy);

    Long countByStatus(Boolean status);

}
