package me.krstic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.krstic.repository.MeasurementRepository;

@Service
public class MeasurementService {

	private static final Logger log = LoggerFactory.getLogger(MeasurementService.class);
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	public MeasurementService() {
	}
	
	
}
