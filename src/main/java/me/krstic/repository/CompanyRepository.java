package me.krstic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

}
