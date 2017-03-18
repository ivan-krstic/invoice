package me.krstic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.krstic.repository.ClientRepository;

@Service
public class ClientService {
	
	private static final Logger log = LoggerFactory.getLogger(ClientService.class);

	@Autowired
	private ClientRepository clientRepository;
	
	public ClientService() {
	}
	
	
}
