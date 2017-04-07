package me.krstic.controller;

import java.util.List;

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
import me.krstic.model.Client;
import me.krstic.service.ClientService;
import me.krstic.vo.ClientAddForm;
import me.krstic.vo.ClientSearchForm;

@Controller
public class ClientController {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceConfiguration invoiceConfiguration;
	
	public ClientController() {
	}
	
	@RequestMapping(path = "/clients")
	public String getClients(Model model) {
		Page<Client> clients = clientService.findAll(0, invoiceConfiguration.getMaxSize());

		model.addAttribute("clientSearchForm", new ClientSearchForm());
		model.addAttribute("clients", clients.getContent());
		model.addAttribute("page", clients.getNumber());
		model.addAttribute("totalElements", clients.getTotalElements());
		model.addAttribute("totalPages", clients.getTotalPages());

		return "clients";
	}
	
	@RequestMapping(path = "/clients", method = RequestMethod.GET, params = {"page"})
	public String getInvoicesByPage(@RequestParam int page, Model model) {
		Page<Client> clients = clientService.findAll(page-1, invoiceConfiguration.getMaxSize());
		
		model.addAttribute("clientSearchForm", new ClientSearchForm());
		model.addAttribute("clients", clients.getContent());
		model.addAttribute("page", clients.getNumber());
		model.addAttribute("totalElements", clients.getTotalElements());
		model.addAttribute("totalPages", clients.getTotalPages());

		return "clients";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET, params = {"id"})
	public String getClientById(@RequestParam int id, Model model) {
		Client client = clientService.findById(id);
		
		model.addAttribute("clientAddForm", new ClientAddForm());
		model.addAttribute("id", client.getId());
		model.addAttribute("name", client.getName());
		model.addAttribute("zipCode", client.getZipCode());
		model.addAttribute("city", client.getCity());
		model.addAttribute("street", client.getStreet());
		model.addAttribute("houseNumber", client.getHouseNumber());
		model.addAttribute("email", client.getEmail());
		model.addAttribute("phone", client.getPhone());
		model.addAttribute("bankAccount", client.getBankAccount());
		model.addAttribute("bankName", client.getBankName());
		model.addAttribute("taxNumber", client.getTaxNumber());
		model.addAttribute("status", client.getStatus());
		
		return "client";
	}
	
	@RequestMapping(value = "/client-search", method = RequestMethod.POST)
	public String getClientsBySearch(ClientSearchForm clientSearchForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		List<Client> clients = clientService.findBySearchForm(clientSearchForm);
		model.addAttribute("clients", clients);
		
		return "clients";
	}
	
	@RequestMapping(value = "/client-add", method = RequestMethod.GET)
	public String addClientForm(Model model) {
		model.addAttribute("clientAddForm", new ClientAddForm());
		
		return "client";
	}
	
	@RequestMapping(value = "/client-add", method = RequestMethod.POST)
	public String addClient(ClientAddForm clientAddForm, Model model) {		
		clientService.createOrUpdate(clientAddForm);
		
		return "redirect:/clients";
	}
}
