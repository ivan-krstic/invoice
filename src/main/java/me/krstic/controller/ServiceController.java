package me.krstic.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.krstic.configuration.InvoiceConfiguration;
import me.krstic.model.Service;
import me.krstic.service.MeasurementService;
import me.krstic.service.ServiceService;
import me.krstic.vo.ServiceAddForm;
import me.krstic.vo.ServiceSearchForm;

@Controller
public class ServiceController {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private MeasurementService measurementService;
	@Autowired
	private InvoiceConfiguration invoiceConfiguration;
	
	public ServiceController() {
	}
	
	@RequestMapping(path = "/services")
	public String getServices(Model model) {
		Page<Service> services = serviceService.findAllActive(0, invoiceConfiguration.getMaxSize());

		model.addAttribute("serviceSearchForm", new ServiceSearchForm());
		model.addAttribute("services", services.getContent());
		model.addAttribute("page", services.getNumber());
		model.addAttribute("totalElements", services.getTotalElements());
		model.addAttribute("totalPages", services.getTotalPages());

		return "services";
	}
	
	@RequestMapping(path = "/services", method = RequestMethod.GET, params = {"page"})
	public String getServicesByPage(@RequestParam int page, Model model) {
		Page<Service> services = serviceService.findAllActive(page-1, invoiceConfiguration.getMaxSize());
		
		model.addAttribute("serviceSearchForm", new ServiceSearchForm());
		model.addAttribute("services", services.getContent());
		model.addAttribute("page", services.getNumber());
		model.addAttribute("totalElements", services.getTotalElements());
		model.addAttribute("totalPages", services.getTotalPages());

		return "services";
	}
	
	@RequestMapping(value = "/service", method = RequestMethod.GET, params = {"id"})
	public String getServiceById(@RequestParam int id, Model model) {
		Service service = serviceService.findById(id);
		
		model.addAttribute("serviceAddForm", new ServiceAddForm());
		model.addAttribute("id", service.getId());
		model.addAttribute("name", service.getName());
		model.addAttribute("measurement", service.getMeasurement());
		model.addAttribute("price", service.getPrice());
		model.addAttribute("status", service.getStatus());
		
		model.addAttribute("measurements", measurementService.findAll());
		
		return "service";
	}
	
	@RequestMapping(value = "/service-search", method = RequestMethod.POST)
	public String getServicesBySearch(ServiceSearchForm serviceSearchForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			
		}
		
		List<Service> services = serviceService.findBySearchForm(serviceSearchForm);
		model.addAttribute("services", services);
		
		return "services";
	}
	
	@RequestMapping(value = "/service-add", method = RequestMethod.GET)
	public String addServiceForm(Model model) {
		model.addAttribute("serviceAddForm", new ServiceAddForm());
		model.addAttribute("measurements", measurementService.findAll());
		
		return "service";
	}
	
	@RequestMapping(value = "/service-add", method = RequestMethod.POST)
	public String addService(@Valid ServiceAddForm serviceAddForm, BindingResult bindingResult, Model model, HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("measurements", measurementService.findAll());
			
			return "service";
		}
		
		serviceService.createOrUpdate(serviceAddForm);
		
		return "redirect:/services";
	}
	
	@RequestMapping(value = "/service-remove", method = RequestMethod.GET, params = {"id"})
	public String removeServiceForm(@RequestParam int id) {
		serviceService.delete(id);
		
		return "redirect:/services";
	}
}
