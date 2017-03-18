package me.krstic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Service;

@Repository
public interface ServiceRepository extends PagingAndSortingRepository<Service, Integer> {

}
