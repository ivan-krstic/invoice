package me.krstic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import me.krstic.model.Measurement;
import me.krstic.repository.MeasurementRepository;

@Service
public class MeasurementService {

	private static final Logger log = LoggerFactory.getLogger(MeasurementService.class);
	
	@Autowired
	private MeasurementRepository measurementRepository;
	
	public MeasurementService() {
	}
	
	public List<Measurement> getAllMeasurements() {
		return (List<Measurement>) measurementRepository.findAll();
	}
	
	public Page<Measurement> getAllMeasurements(int page, int size) {
		return measurementRepository.findAll(new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public Measurement findById(int id) {
		return measurementRepository.findOne(id);
	}
}
