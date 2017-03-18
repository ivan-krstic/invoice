package me.krstic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import me.krstic.service.MeasurementService;

@Controller
public class MeasurementController {

	private static final Logger log = LoggerFactory.getLogger(MeasurementController.class);
	
	@Autowired
	private MeasurementService measurementService;
	
	public MeasurementController() {
	}
	
	
}
