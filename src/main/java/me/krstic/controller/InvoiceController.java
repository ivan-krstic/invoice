package me.krstic.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.krstic.configuration.InvoiceConfiguration;
import me.krstic.model.Client;
import me.krstic.model.Invoice;
import me.krstic.model.Owner;
import me.krstic.service.ClientService;
import me.krstic.service.InvoiceService;
import me.krstic.service.JasperReportService;
import me.krstic.service.OwnerService;
import me.krstic.service.ServiceService;
import me.krstic.service.XmlService;
import me.krstic.vo.AutocompleteData;
import me.krstic.vo.InvoiceCreateForm;
import me.krstic.vo.InvoiceSearchForm;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;

@Controller
public class InvoiceController {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);
	
	@Autowired
	private InvoiceConfiguration invoiceConfiguration;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private OwnerService ownerService;
	@Autowired
	private XmlService xmlService;
	@Autowired
	private JasperReportService jasperReportService;
	
	public InvoiceController() {
	}
	
	@RequestMapping(path = "/invoices")
	public String getInvoices(Model model) {
		Page<Invoice> invoices = invoiceService.findAll(0, invoiceConfiguration.getMaxSize());

		model.addAttribute("invoiceSearchForm", new InvoiceSearchForm());
		model.addAttribute("invoices", invoices.getContent());
		model.addAttribute("page", invoices.getNumber());
		model.addAttribute("totalElements", invoices.getTotalElements());
		model.addAttribute("totalPages", invoices.getTotalPages());

		return "invoices";
	}
	
	@RequestMapping(path = "/invoices", method = RequestMethod.GET, params = {"page"})
	public String getInvoicesByPage(@RequestParam int page, Model model) {
		Page<Invoice> invoices = invoiceService.findAll(page-1, invoiceConfiguration.getMaxSize());
		
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
		
		List<Invoice> invoices = invoiceService.findBySearchForm(invoiceSearchForm);
		model.addAttribute("invoices", invoices);
		
		return "invoices";
	}
	
	@RequestMapping(value = "/invoice-create", method = RequestMethod.GET)
	public String invoiceCreateForm(Model model) {
		List<Client> clients = clientService.findAll();
		Owner owner = ownerService.getOwner();
		
		List<AutocompleteData> clientData = new ArrayList<AutocompleteData>();
		
		for (Client client : clients) {
			clientData.add(new AutocompleteData(client.getName() + ", " + client.getZipCode() + " " + client.getCity() + ", " + client.getStreet(), client.getId().toString()));
		}
		
		model.addAttribute("invoiceCreateForm", new InvoiceCreateForm());
		model.addAttribute("invoiceNumber", invoiceService.getInvoiceNumber());
		model.addAttribute("services", serviceService.findAll());
		model.addAttribute("clients", clientData);
		model.addAttribute("ownerName", owner.getName());
		model.addAttribute("ownerCity", owner.getZipCode() + " " + owner.getCity());
		model.addAttribute("ownerStreet", owner.getStreet() + " " + owner.getHouseNumber());
		
		log.info("Owner: " + owner);
		
		return "invoice-create";
	}
	
	@RequestMapping(value = "/invoice-create", method = RequestMethod.POST)
	public String invoiceCreate(@Valid InvoiceCreateForm invoiceCreateForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
		}
		
		invoiceService.createOrUpdate(invoiceCreateForm);

		return "redirect:/invoices";
	}

/*
	@RequestMapping(value = "/invoice-generate", method = RequestMethod.GET)
	public void generateReport(@RequestParam(value = "id") int id, HttpServletResponse response) throws IOException, JRException, NamingException, SQLException {
		Map<String, Object> parameters = new HashedMap();
		parameters.put("id", id);
		
		JasperReport jasperReport = jasperReportService.getFile();
		
		jasperReportService.generateInvoicePDF(response, parameters, jasperReport);
	}
*/
	@RequestMapping(value = "/invoice-pdf", method = RequestMethod.GET)
	public HttpEntity<byte[]> getPdfById(@RequestParam(value = "id") int id, HttpServletResponse response) throws IOException, JRException, NamingException, SQLException {
		Map<String, Object> parameters = new HashedMap();
		parameters.put("id", id);
		
		JasperReport jasperReport = jasperReportService.getFile();
		
		byte[] documentBody = jasperReportService.generateInvoicePDF(response, parameters, jasperReport);
		
		HttpHeaders header = new HttpHeaders();
		
		header.setContentType(MediaType.TEXT_XML);
		header.setContentLength(documentBody.length);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice_" + id + ".pdf");
		
		return new HttpEntity<byte[]>(documentBody, header);
	}

	@RequestMapping(value = "/invoice-xml", method = RequestMethod.GET, params = {"id"})
	public HttpEntity<byte[]> getXmlById(@RequestParam int id) {
		Invoice invoice = invoiceService.findById(id);
		
		HttpHeaders header = new HttpHeaders();
		
		byte[] documentBody = xmlService.createInvoiceXml(invoice).getBytes();
		
		header.setContentType(MediaType.TEXT_XML);
		header.setContentLength(documentBody.length);
		header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice_" + id + ".xml");
		
		return new HttpEntity<byte[]>(documentBody, header);
	}
}
