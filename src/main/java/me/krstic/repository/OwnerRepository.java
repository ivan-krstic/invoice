package me.krstic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Integer> {

}
