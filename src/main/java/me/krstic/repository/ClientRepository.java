package me.krstic.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Client;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Integer>, JpaSpecificationExecutor<Client> {

}
