package com.wedding.planner.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wedding.planner.entity.ServiceItem;
import com.wedding.planner.entity.Services;

public interface ServiceItemRepository extends JpaRepository<ServiceItem, Long> {

	Long countByService(Services service);

	List<ServiceItem> findByStatus(Boolean status);

	List<ServiceItem> findByStatus(Boolean status, Pageable page);

	List<ServiceItem> findByService(Services service);

	List<ServiceItem> findByServiceAndStatus(Services service,Boolean status);

	List<ServiceItem> findByServiceAndStatus(Services service,Boolean status,Pageable page);

	@Query(value = "SELECT si FROM ServiceItem si WHERE si.service = :service ORDER BY RAND() LIMIT 1")
	Optional<ServiceItem> findRandomByService(@Param("service") Services service);

}
