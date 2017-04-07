package me.krstic.vo;

import org.hibernate.validator.constraints.NotEmpty;

public class ClientAddForm {

	private Integer id;
	@NotEmpty(message = "Client name is empty.")
	private String name;
	@NotEmpty(message = "Client zip code is empty.")
	private String zipCode;
	@NotEmpty(message = "Client city is empty.")
	private String city;
	@NotEmpty(message = "Client street is empty.")
	private String street;
	private String houseNumber;
	private String email;
	private String phone;
	private String bankAccount;
	private String bankName;
	private String taxNumber;
	private String modifiedBy;
	
	public ClientAddForm() {
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

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "\"ClientAddForm\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"zipCode\": \""
				+ zipCode + "\",\n\t\"city\": \"" + city + "\",\n\t\"street\": \"" + street
				+ "\",\n\t\"houseNumber\": \"" + houseNumber + "\",\n\t\"email\": \"" + email + "\",\n\t\"phone\": \""
				+ phone + "\",\n\t\"bankAccount\": \"" + bankAccount + "\",\n\t\"bankName\": \"" + bankName
				+ "\",\n\t\"taxNumber\": \"" + taxNumber + "\",\n\t\"modifiedBy\": \"" + modifiedBy + "\"\n}";
	}
}
