package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String email;
	private String phone;
	private String bankAccount;
	private String bankName;
	private String taxNumber;
	private Integer status;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User modifiedBy;
	
	public Client() {
	}

	public Client(String name, String zipCode, String city, String street, String houseNumber, String email,
			String phone, String bankAccount, String bankName, String taxNumber, User modifiedBy) {
		super();
		this.name = name;
		this.zipCode = zipCode;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
		this.email = email;
		this.phone = phone;
		this.bankAccount = bankAccount;
		this.bankName = bankName;
		this.taxNumber = taxNumber;
		this.status = 1;
		this.modifiedOn = new Date();
		this.modifiedBy = modifiedBy;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
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

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "\"Client\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"zipCode\": \"" + zipCode
				+ "\",\n\t\"city\": \"" + city + "\",\n\t\"street\": \"" + street + "\",\n\t\"houseNumber\": \""
				+ houseNumber + "\",\n\t\"email\": \"" + email + "\",\n\t\"phone\": \"" + phone
				+ "\",\n\t\"bankAccount\": \"" + bankAccount + "\",\n\t\"bankName\": \"" + bankName
				+ "\",\n\t\"taxNumber\": \"" + taxNumber + "\",\n\t\"status\": \"" + status
				+ "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\",\n\t\"modifiedBy\": \"" + modifiedBy + "\"\n}";
	}
}
