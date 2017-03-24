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
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;
	@Autowired
	private InvoiceConfiguration invoiceConfiguration;
	
	public ClientController() {
	}
	
	@RequestMapping(path = "/clients")
	public String getClients(Model model) {
		Page<Client> clients = clientService.getAllClients(0, invoiceConfiguration.getMaxSize());

		model.addAttribute("clientSearchForm", new ClientSearchForm());
		model.addAttribute("clients", clients.getContent());
		model.addAttribute("page", clients.getNumber());
		model.addAttribute("totalElements", clients.getTotalElements());
		model.addAttribute("totalPages", clients.getTotalPages());

		return "clients";
	}
	
	@RequestMapping(path = "/clients", method = RequestMethod.GET, params = {"page"})
	public String getInvoicesByPage(@RequestParam int page, Model model) {
		Page<Client> clients = clientService.getAllClients(page-1, invoiceConfiguration.getMaxSize());
		
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
		model.addAttribute("status", client.getStatus());
		
		return "client";
	}
	
	@RequestMapping(value = "/searchClients", method = RequestMethod.POST)
	public String getClientsBySearch(ClientSearchForm clientSearchForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		List<Client> clients = clientService.findByClientSearchForm(clientSearchForm);
		model.addAttribute("clients", clients);
		
		return "clients";
	}
	
	@RequestMapping(value = "/add-client", method = RequestMethod.GET)
	public String addClientForm(Model model) {
		model.addAttribute("clientAddForm", new ClientAddForm());
		
		return "client";
	}
	
	@RequestMapping(value = "/addClient", method = RequestMethod.POST)
	public String addClient(@Valid ClientAddForm clientAddForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		Client client;
		
		if (clientAddForm.getId() != null) {
			log.info("ID: " + clientAddForm.getId());
			
			client = clientService.findById(clientAddForm.getId());
			
			if (clientAddForm.getName() != null && !clientAddForm.getName().isEmpty()) {
				client.setName(clientAddForm.getName());
			}
			if (clientAddForm.getZipCode() != null && !clientAddForm.getZipCode().isEmpty()) {
				client.setZipCode(clientAddForm.getZipCode());
			}
			if (clientAddForm.getCity() != null && !clientAddForm.getCity().isEmpty()) {
				client.setCity(clientAddForm.getCity());
			}
			if (clientAddForm.getStreet() != null && !clientAddForm.getStreet().isEmpty()) {
				client.setStreet(clientAddForm.getStreet());
			}
			if (clientAddForm.getHouseNumber() != null && !clientAddForm.getHouseNumber().isEmpty()) {
				client.setHouseNumber(clientAddForm.getHouseNumber());
			}
		} else {
			client = new Client(
				clientAddForm.getName().isEmpty() ? null : clientAddForm.getName(),
				clientAddForm.getZipCode().isEmpty() ? null : clientAddForm.getZipCode(),
				clientAddForm.getCity().isEmpty() ? null : clientAddForm.getCity(),
				clientAddForm.getStreet().isEmpty() ? null : clientAddForm.getStreet(),
				clientAddForm.getHouseNumber().isEmpty() ? null : clientAddForm.getHouseNumber(),
				1);
		}
		
		if (client != null) {
			clientService.saveClient(client);
		}
		
		return "redirect:/clients";
	}
}
