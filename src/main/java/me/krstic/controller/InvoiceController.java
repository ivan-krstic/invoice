package me.krstic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.krstic.service.InvoiceService;

@Controller
public class InvoiceController {

	private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);
	
	@Autowired
	private InvoiceService invoiceService;
	
	public InvoiceController() {
	}
	
	
}
