package me.krstic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.krstic.service.ServiceService;

@Controller
public class ServiceController {

	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServiceService serviceService;
	
	public ServiceController() {
	}
	
	
}
