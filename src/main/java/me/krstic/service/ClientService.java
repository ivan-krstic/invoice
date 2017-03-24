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
import me.krstic.vo.ClientSearchForm;

@Service
public class ClientService {
	
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService() {
	}
	
	public Page<Client> getAllClients(int page, int size) {
		return clientRepository.findAll(new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client findById(int id) {
		return clientRepository.findOne(id);
	}
	
	public List<Client> findByClientSearchForm(ClientSearchForm clientSearchForm) {
		return clientRepository.findAll(Specifications.where(ClientSearchSpecification.hasName(clientSearchForm.getName()))
				.and(ClientSearchSpecification.hasZipCode(clientSearchForm.getZipCode()))
				.and(ClientSearchSpecification.hasCity(clientSearchForm.getCity()))
				.and(ClientSearchSpecification.hasStreet(clientSearchForm.getStreet())));
	}
}
