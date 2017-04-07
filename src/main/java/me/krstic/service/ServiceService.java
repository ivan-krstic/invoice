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

import me.krstic.repository.ServiceRepository;
import me.krstic.specification.ServiceSearchSpecification;
import me.krstic.vo.ServiceAddForm;
import me.krstic.vo.ServiceSearchForm;

@Service
public class ServiceService {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ServiceService.class);
	
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private MeasurementService measurementService;
	@Autowired
	private UserService userService;

	public ServiceService() {
	}
	
	public List<me.krstic.model.Service> findAll() {
		return (List<me.krstic.model.Service>) serviceRepository.findAll();
	}
	
	public Page<me.krstic.model.Service> findAll(int page, int size) {
		return serviceRepository.findAll(new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public Page<me.krstic.model.Service> findAllActive(int page, int size) {
		return serviceRepository.findAllByStatus(1, new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public me.krstic.model.Service findById(int id) {
		return serviceRepository.findOne(id);
	}
	
	public List<me.krstic.model.Service> findBySearchForm(ServiceSearchForm serviceSearchForm) {
		return serviceRepository.findAll(Specifications.where(ServiceSearchSpecification.hasName(serviceSearchForm.getName())));
	}
	
	public me.krstic.model.Service save(me.krstic.model.Service service) {
		return serviceRepository.save(service);
	}
	
	public void delete(int id) {
		me.krstic.model.Service service = findById(id);
		service.setStatus(0);
		
		save(service);
	}
	
	public me.krstic.model.Service createOrUpdate(ServiceAddForm serviceAddForm) {
		me.krstic.model.Service service;
		
		if (serviceAddForm.getId() != null) {
			service = findById(serviceAddForm.getId());
			
			if (serviceAddForm.getName() != null && !serviceAddForm.getName().isEmpty()) {
				service.setName(serviceAddForm.getName());
			}
			if (serviceAddForm.getPrice() != null && serviceAddForm.getPrice() != 0) {
				service.setPrice(serviceAddForm.getPrice());
			}
			if (serviceAddForm.getMeasurementId() != null && serviceAddForm.getMeasurementId() != 0) {
				service.setMeasurement(measurementService.findById(serviceAddForm.getMeasurementId()));
			}
		} else {
			service = new me.krstic.model.Service(
					serviceAddForm.getName().isEmpty() ? null : serviceAddForm.getName(),
					serviceAddForm.getPrice() == 0 ? null : serviceAddForm.getPrice(),
					measurementService.findById(serviceAddForm.getMeasurementId()),
					userService.findByUsername(serviceAddForm.getModifiedBy()));
		}
		
		if (service != null) {
			return save(service);
		} else {
			return null;
		}
	}
}
