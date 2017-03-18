package me.krstic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.krstic.service.ClientService;

@Controller
public class ClientController {
	
	private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService clientService;
	
	public ClientController() {
	}
	
	
}
