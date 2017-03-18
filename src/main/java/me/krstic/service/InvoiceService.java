package me.krstic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.krstic.repository.InvoiceRepository;

@Service
public class InvoiceService {

	private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public InvoiceService() {
	}
	
	
}
