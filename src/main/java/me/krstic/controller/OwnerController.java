package me.krstic.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import me.krstic.model.Owner;
import me.krstic.service.OwnerService;

@Controller
public class OwnerController {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OwnerController.class);

	@Autowired
	private OwnerService ownerService;
	
	public OwnerController() {
	}
	
	@RequestMapping(path = "/owners")
	public String getOwners(Model model) {
		List<Owner> companies = ownerService.findAll();

		model.addAttribute("companies", companies);

		return "owners";
	}
	
	@RequestMapping(value = "/owner", method = RequestMethod.GET, params = {"id"})
	public String getOwnerById(@RequestParam int id, Model model) {
		Owner owner = ownerService.findById(id);
		
		model.addAttribute("ownerAddForm", new Owner());
		model.addAttribute("id", owner.getId());
		model.addAttribute("name", owner.getName());
		model.addAttribute("zipCode", owner.getZipCode());
		model.addAttribute("city", owner.getCity());
		model.addAttribute("street", owner.getStreet());
		model.addAttribute("houseNumber", owner.getHouseNumber());
		model.addAttribute("email", owner.getEmail());
		model.addAttribute("phone", owner.getPhone());
		model.addAttribute("facebook", owner.getFacebook());
		model.addAttribute("twitter", owner.getTwitter());
		model.addAttribute("bankAccount", owner.getBankAccount());
		model.addAttribute("bankName", owner.getBankName());
		model.addAttribute("taxNumber", owner.getTaxNumber());
		model.addAttribute("status", owner.getStatus());
		
		return "owner";
	}
	
	@RequestMapping(value = "/owner-add", method = RequestMethod.GET)
	public String addOwnerForm(Model model) {
		model.addAttribute("ownerAddForm", new Owner());
		
		return "owner";
	}
	
	@RequestMapping(value = "/owner-add", method = RequestMethod.POST)
	public String addOwner(@Valid Owner ownerForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "owner";
		}
		
		ownerService.createOrUpdate(ownerForm);
		
		return "redirect:/owners";
	}
}
