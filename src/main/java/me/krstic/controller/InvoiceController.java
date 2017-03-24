package me.krstic.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.krstic.configuration.InvoiceConfiguration;
import me.krstic.model.Invoice;
import me.krstic.service.ClientService;
import me.krstic.service.InvoiceService;
import me.krstic.service.ServiceService;
import me.krstic.vo.InvoiceCreateForm;
import me.krstic.vo.InvoiceSearchForm;

@Controller
public class InvoiceController {

	private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);
	
	@Autowired
	private InvoiceConfiguration invoiceConfiguration;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private ClientService clientService;
	
	public InvoiceController() {
	}
	
	@RequestMapping(path = "/invoices")
	public String getInvoices(Model model) {
		Page<Invoice> invoices = invoiceService.getAllInvoices(0, invoiceConfiguration.getMaxSize());

		model.addAttribute("invoiceSearchForm", new InvoiceSearchForm());
		model.addAttribute("invoices", invoices.getContent());
		model.addAttribute("page", invoices.getNumber());
		model.addAttribute("totalElements", invoices.getTotalElements());
		model.addAttribute("totalPages", invoices.getTotalPages());

		return "invoices";
	}
	
	@RequestMapping(path = "/invoices", method = RequestMethod.GET, params = {"page"})
	public String getInvoicesByPage(@RequestParam int page, Model model) {
		Page<Invoice> invoices = invoiceService.getAllInvoices(page-1, invoiceConfiguration.getMaxSize());
		
		model.addAttribute("invoiceSearchForm", new InvoiceSearchForm());
		model.addAttribute("invoices", invoices.getContent());
		model.addAttribute("page", invoices.getNumber());
		model.addAttribute("totalElements", invoices.getTotalElements());
		model.addAttribute("totalPages", invoices.getTotalPages());

		return "invoices";
	}
	
	@RequestMapping(value = "/invoice", method = RequestMethod.GET, params = {"id"})
	public String getInvoiceById(@RequestParam int id, Model model) {
		Invoice invoice = invoiceService.findById(id);
		
		model.addAttribute("id", invoice.getId());
		model.addAttribute("number", invoice.getNumber());
		model.addAttribute("clientName", invoice.getClient().getName());
		model.addAttribute("clientCity", invoice.getClient().getCity());
		model.addAttribute("clientStreet", invoice.getClient().getStreet());
		model.addAttribute("clientZipCode", invoice.getClient().getZipCode());
		model.addAttribute("clientHouseNumber", invoice.getClient().getHouseNumber());
		model.addAttribute("invoiceDate", invoice.getInvoiceDate());
		model.addAttribute("invoiceItems", invoice.getInvoiceItems());
		model.addAttribute("status", invoice.getStatus());
		
		return "invoice";
	}
	
	@RequestMapping(value = "/searchInvoices", method = RequestMethod.POST)
	public String getInvoicesBySearch(InvoiceSearchForm invoiceSearchForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		List<Invoice> invoices = invoiceService.findByInvoiceSearchForm(invoiceSearchForm);
		model.addAttribute("invoices", invoices);
		
		return "invoices";
	}
	
	@RequestMapping(value = "/create-invoice", method = RequestMethod.GET)
	public String createInvoiceForm(Model model) {
		model.addAttribute("invoiceCreateForm", new InvoiceCreateForm());
		
		model.addAttribute("services", serviceService.getAllServices());
		
		return "create-invoice";
	}
	
	@RequestMapping(value = "/createInvoice", method = RequestMethod.POST)
	public String addService(@Valid InvoiceCreateForm invoiceCreateForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		Invoice invoice;
		
		if (invoiceCreateForm.getId() != null) {
			log.info("ID: " + invoiceCreateForm.getId());
			
			invoice = invoiceService.findById(invoiceCreateForm.getId());
			
			// NEED implementation.
		} else {
			invoice = new Invoice(
				invoiceCreateForm.getNumber().isEmpty() ? null : invoiceCreateForm.getNumber(),
				1,
				clientService.findById(invoiceCreateForm.getClientId()),
				null,
				invoiceCreateForm.getInvoiceDate());
		}
		
		if (invoice != null) {
			invoiceService.saveInvoice(invoice);
		}
		
		return "redirect:/invoices";
	}
}
