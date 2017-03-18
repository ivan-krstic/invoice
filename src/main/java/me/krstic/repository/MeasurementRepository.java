package me.krstic.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Measurement;

@Repository
public interface MeasurementRepository extends PagingAndSortingRepository<Measurement, Integer> {

}
