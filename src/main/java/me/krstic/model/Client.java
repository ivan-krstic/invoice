package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Client {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	private String zipCode;
	private String city;
	private String street;
	private String houseNumber;
	private Integer status;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	
	public Client() {
	}
/*
	public Client(String name, String zipCode, String city, String street, String houseNumber, Integer status) {
		if (name != null) {
			this.name = name;
		}
		if (zipCode != null) {
			this.zipCode = zipCode;
		}
		if (city != null) {
			this.city = city;
		}
		if (street != null) {
			this.street = street;
		}
		if (houseNumber != null) {
			this.houseNumber = houseNumber;
		}
		this.status = status;
	}
*/
	public Client(String name, String zipCode, String city, String street, String houseNumber, Integer status) {
		this.name = name;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.status = status;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "\"Client\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"zipCode\": \"" + zipCode
				+ "\",\n\t\"city\": \"" + city + "\",\n\t\"street\": \"" + street + "\",\n\t\"houseNumber\": \""
				+ houseNumber + "\",\n\t\"status\": \"" + status + "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\"\n}";
	}
}
