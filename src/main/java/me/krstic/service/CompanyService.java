package me.krstic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.krstic.model.Company;
import me.krstic.repository.CompanyRepository;

@Service
public class CompanyService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CompanyService.class);

	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyService() {
	}
	
	public List<Company> findAll() {
		return (List<Company>) companyRepository.findAll();
	}
	
	public Company findById(int id) {
		return companyRepository.findOne(id);
	}
	
	public Company save(Company client) {
		return companyRepository.save(client);
	}
	
	public Company createOrUpdate(Company companyForm) {
		Company company;
		
		if (companyForm.getId() != null) {
			company = findById(companyForm.getId());
			
			if (companyForm.getName() != null && !companyForm.getName().isEmpty()) {
				company.setName(companyForm.getName());
			}
			if (companyForm.getZipCode() != null && !companyForm.getZipCode().isEmpty()) {
				company.setZipCode(companyForm.getZipCode());
			}
			if (companyForm.getCity() != null && !companyForm.getCity().isEmpty()) {
				company.setCity(companyForm.getCity());
			}
			if (companyForm.getStreet() != null && !companyForm.getStreet().isEmpty()) {
				company.setStreet(companyForm.getStreet());
			}
			if (companyForm.getHouseNumber() != null && !companyForm.getHouseNumber().isEmpty()) {
				company.setHouseNumber(companyForm.getHouseNumber());
			}
		} else {
			company = new Company(
					companyForm.getName().isEmpty() ? null : companyForm.getName(),
					companyForm.getZipCode().isEmpty() ? null : companyForm.getZipCode(),
					companyForm.getCity().isEmpty() ? null : companyForm.getCity(),
					companyForm.getStreet().isEmpty() ? null : companyForm.getStreet(),
					companyForm.getHouseNumber().isEmpty() ? null : companyForm.getHouseNumber(),
					companyForm.getEmail().isEmpty() ? null : companyForm.getEmail(),
					companyForm.getPhone().isEmpty() ? null : companyForm.getPhone(),
					companyForm.getFacebook().isEmpty() ? null : companyForm.getFacebook(),
					companyForm.getTwitter().isEmpty() ? null : companyForm.getTwitter(),
					companyForm.getBankAccount().isEmpty() ? null : companyForm.getBankAccount(),
					companyForm.getBankName().isEmpty() ? null : companyForm.getBankName(),
					companyForm.getTaxNumber().isEmpty() ? null : companyForm.getTaxNumber(),
					null); // modifiedBy
		}
		
		if (company != null) {
			return save(company);
		} else {
			return null;
		}
	}
}
