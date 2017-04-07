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

import me.krstic.model.Company;
import me.krstic.service.CompanyService;

@Controller
public class CompanyController {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;
	
	public CompanyController() {
	}
	
	@RequestMapping(path = "/companies")
	public String getCompanies(Model model) {
		List<Company> companies = companyService.findAll();

		model.addAttribute("companies", companies);

		return "companies";
	}
	
	@RequestMapping(value = "/company", method = RequestMethod.GET, params = {"id"})
	public String getCompanyById(@RequestParam int id, Model model) {
		Company company = companyService.findById(id);
		
		model.addAttribute("companyAddForm", new Company());
		model.addAttribute("id", company.getId());
		model.addAttribute("name", company.getName());
		model.addAttribute("zipCode", company.getZipCode());
		model.addAttribute("city", company.getCity());
		model.addAttribute("street", company.getStreet());
		model.addAttribute("houseNumber", company.getHouseNumber());
		model.addAttribute("email", company.getEmail());
		model.addAttribute("phone", company.getPhone());
		model.addAttribute("facebook", company.getFacebook());
		model.addAttribute("twitter", company.getTwitter());
		model.addAttribute("bankAccount", company.getBankAccount());
		model.addAttribute("bankName", company.getBankName());
		model.addAttribute("taxNumber", company.getTaxNumber());
		model.addAttribute("status", company.getStatus());
		
		return "company";
	}
	
	@RequestMapping(value = "/company-add", method = RequestMethod.GET)
	public String addCompanyForm(Model model) {
		model.addAttribute("companyAddForm", new Company());
		
		return "company";
	}
	
	@RequestMapping(value = "/company-add", method = RequestMethod.POST)
	public String addCompany(@Valid Company companyForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "company";
		}
		
		companyService.createOrUpdate(companyForm);
		
		return "redirect:/companies";
	}
}
