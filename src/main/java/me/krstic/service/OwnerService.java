package me.krstic.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.krstic.model.Owner;
import me.krstic.repository.OwnerRepository;

@Service
public class OwnerService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(OwnerService.class);

	@Autowired
	private OwnerRepository ownerRepository;
	private Owner owner;
	
	public OwnerService() {
	}
	
	@PostConstruct
    public void init() {
        owner = findById(1);
    }
	
	public List<Owner> findAll() {
		return (List<Owner>) ownerRepository.findAll();
	}
	
	public Owner findById(int id) {
		return ownerRepository.findOne(id);
	}
	
	public Owner save(Owner client) {
		return ownerRepository.save(client);
	}
	
	public Owner createOrUpdate(Owner ownerForm) {
		Owner owner;
		
		if (ownerForm.getId() != null) {
			owner = findById(ownerForm.getId());
			
			if (ownerForm.getName() != null && !ownerForm.getName().isEmpty()) {
				owner.setName(ownerForm.getName());
			}
			if (ownerForm.getZipCode() != null && !ownerForm.getZipCode().isEmpty()) {
				owner.setZipCode(ownerForm.getZipCode());
			}
			if (ownerForm.getCity() != null && !ownerForm.getCity().isEmpty()) {
				owner.setCity(ownerForm.getCity());
			}
			if (ownerForm.getStreet() != null && !ownerForm.getStreet().isEmpty()) {
				owner.setStreet(ownerForm.getStreet());
			}
			if (ownerForm.getHouseNumber() != null && !ownerForm.getHouseNumber().isEmpty()) {
				owner.setHouseNumber(ownerForm.getHouseNumber());
			}
		} else {
			owner = new Owner(
					ownerForm.getName().isEmpty() ? null : ownerForm.getName(),
					ownerForm.getZipCode().isEmpty() ? null : ownerForm.getZipCode(),
					ownerForm.getCity().isEmpty() ? null : ownerForm.getCity(),
					ownerForm.getStreet().isEmpty() ? null : ownerForm.getStreet(),
					ownerForm.getHouseNumber().isEmpty() ? null : ownerForm.getHouseNumber(),
					ownerForm.getEmail().isEmpty() ? null : ownerForm.getEmail(),
					ownerForm.getPhone().isEmpty() ? null : ownerForm.getPhone(),
					ownerForm.getFacebook().isEmpty() ? null : ownerForm.getFacebook(),
					ownerForm.getTwitter().isEmpty() ? null : ownerForm.getTwitter(),
					ownerForm.getBankAccount().isEmpty() ? null : ownerForm.getBankAccount(),
					ownerForm.getBankName().isEmpty() ? null : ownerForm.getBankName(),
					ownerForm.getTaxNumber().isEmpty() ? null : ownerForm.getTaxNumber(),
					null); // modifiedBy
		}
		
		if (owner != null) {
			return save(owner);
		} else {
			return null;
		}
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
