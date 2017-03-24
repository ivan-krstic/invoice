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
import me.krstic.vo.ServiceSearchForm;

@Service
public class ServiceService {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceService.class);
	
	@Autowired
	private ServiceRepository serviceRepository;

	public ServiceService() {
	}
	
	public List<me.krstic.model.Service> getAllServices() {
		return (List<me.krstic.model.Service>) serviceRepository.findAll();
	}
	
	public Page<me.krstic.model.Service> getAllServices(int page, int size) {
		return serviceRepository.findAll(new PageRequest(page, size, Direction.ASC, "name"));
	}
	
	public me.krstic.model.Service saveService(me.krstic.model.Service service) {
		return serviceRepository.save(service);
	}
	
	public me.krstic.model.Service findById(int id) {
		return serviceRepository.findOne(id);
	}
	
	public List<me.krstic.model.Service> findByServiceSearchForm(ServiceSearchForm serviceSearchForm) {
		return serviceRepository.findAll(Specifications.where(ServiceSearchSpecification.hasName(serviceSearchForm.getName())));
	}
}
