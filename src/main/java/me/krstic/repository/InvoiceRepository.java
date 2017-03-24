package me.krstic.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import me.krstic.model.Invoice;

@Repository
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Integer>, JpaSpecificationExecutor<Invoice> {

}
