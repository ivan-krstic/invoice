package me.krstic.vo;

public class ClientSearchForm {

	private String name;
	private String zipCode;
	private String city;
	private String street;
	
	public ClientSearchForm() {
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

	@Override
	public String toString() {
		return "\"ClientSearchForm\": {\n\t\"name\": \"" + name + "\",\n\t\"zipCode\": \"" + zipCode
				+ "\",\n\t\"city\": \"" + city + "\",\n\t\"street\": \"" + street + "\"\n}";
	}
}
