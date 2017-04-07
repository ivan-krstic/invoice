package me.krstic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Service;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Integer>, JpaSpecificationExecutor<Service> {

	Page<Service> findAllByStatus(int status, Pageable pageable);
	
}
