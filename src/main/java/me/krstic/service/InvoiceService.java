package me.krstic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import me.krstic.model.Invoice;
import me.krstic.repository.InvoiceRepository;
import me.krstic.specification.InvoiceSearchSpecification;
import me.krstic.vo.InvoiceSearchForm;

@Service
public class InvoiceService {

	private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public InvoiceService() {
	}
	
	public Page<Invoice> getAllInvoices(int page, int size) {
		return invoiceRepository.findAll(new PageRequest(page, size, Direction.DESC, "invoiceDate"));
	}
	
	public Invoice findById(int id) {
		return invoiceRepository.findOne(id);
	}
	
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> findByInvoiceSearchForm(InvoiceSearchForm invoiceSearchForm) {
		return invoiceRepository.findAll(Specifications.where(InvoiceSearchSpecification.hasClientName(invoiceSearchForm.getClientName()))
				.and(InvoiceSearchSpecification.hasInvoiceDateFrom(invoiceSearchForm.getInvoiceDateFrom()))
				.and(InvoiceSearchSpecification.hasInvoiceDateTo(invoiceSearchForm.getInvoiceDateTo()))
				.and(InvoiceSearchSpecification.hasStatus(invoiceSearchForm.getStatus())));
	}
}
