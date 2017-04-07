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

import me.krstic.model.Client;
import me.krstic.repository.ClientRepository;
import me.krstic.specification.ClientSearchSpecification;
import me.krstic.vo.ClientAddForm;
import me.krstic.vo.ClientSearchForm;

@Service
public class ClientService {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private UserService userService;
	
	public ClientService() {
	}
	
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}
	
	public Page<Client> findAll(int page, int size) {
		return clientRepository.findAll(new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public Page<Client> findAllActive(int page, int size) {
		return clientRepository.findAllByStatus(1, new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public Client findById(int id) {
		return clientRepository.findOne(id);
	}
	
	public List<Client> findBySearchForm(ClientSearchForm clientSearchForm) {
		return clientRepository.findAll(Specifications.where(ClientSearchSpecification.hasName(clientSearchForm.getName()))
				.and(ClientSearchSpecification.hasZipCode(clientSearchForm.getZipCode()))
				.and(ClientSearchSpecification.hasCity(clientSearchForm.getCity()))
				.and(ClientSearchSpecification.hasStreet(clientSearchForm.getStreet())));
	}
	
	public Client save(Client client) {
		return clientRepository.save(client);
	}
	
	public void delete(int id) {
		Client client = findById(id);
		client.setStatus(0);
		
		save(client);
	}
	
	public Client createOrUpdate(ClientAddForm clientAddForm) {
		Client client;
		
		if (clientAddForm.getId() != null) {
			client = findById(clientAddForm.getId());
			
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
			if (clientAddForm.getEmail() != null && !clientAddForm.getEmail().isEmpty()) {
				client.setEmail(clientAddForm.getEmail());
			}
			if (clientAddForm.getPhone() != null && !clientAddForm.getPhone().isEmpty()) {
				client.setPhone(clientAddForm.getPhone());
			}
			if (clientAddForm.getBankAccount() != null && !clientAddForm.getBankAccount().isEmpty()) {
				client.setBankAccount(clientAddForm.getBankAccount());
			}
			if (clientAddForm.getBankName() != null && !clientAddForm.getBankName().isEmpty()) {
				client.setBankName(clientAddForm.getBankName());
			}
			if (clientAddForm.getTaxNumber() != null && !clientAddForm.getTaxNumber().isEmpty()) {
				client.setTaxNumber(clientAddForm.getTaxNumber());
			}
		} else {
			client = new Client(
					clientAddForm.getName().isEmpty() ? null : clientAddForm.getName(),
					clientAddForm.getZipCode().isEmpty() ? null : clientAddForm.getZipCode(),
					clientAddForm.getCity().isEmpty() ? null : clientAddForm.getCity(),
					clientAddForm.getStreet().isEmpty() ? null : clientAddForm.getStreet(),
					clientAddForm.getHouseNumber().isEmpty() ? null : clientAddForm.getHouseNumber(),
					clientAddForm.getEmail().isEmpty() ? null : clientAddForm.getEmail(),
					clientAddForm.getPhone().isEmpty() ? null : clientAddForm.getPhone(),
					clientAddForm.getBankAccount().isEmpty() ? null : clientAddForm.getBankAccount(),
					clientAddForm.getBankName().isEmpty() ? null : clientAddForm.getBankName(),
					clientAddForm.getTaxNumber().isEmpty() ? null : clientAddForm.getTaxNumber(),
					userService.findByUsername(clientAddForm.getModifiedBy()));
		}
		
		if (client != null) {
			return save(client);
		} else {
			return null;
		}
	}
}
