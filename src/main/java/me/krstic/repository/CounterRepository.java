package me.krstic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Counter;

@Repository
public interface CounterRepository extends CrudRepository<Counter, Integer> {

	Counter findOneByName(String name);
	
}
