package me.krstic.vo;

public class ClientAddForm {

	private Integer id;
	private String name;
	private String zipCode;
	private String city;
	private String street;
	private String houseNumber;
	
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

	@Override
	public String toString() {
		return "\"ClientAddForm\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"zipCode\": \""
				+ zipCode + "\",\n\t\"city\": \"" + city + "\",\n\t\"street\": \"" + street
				+ "\",\n\t\"houseNumber\": \"" + houseNumber + "\"\n}";
	}
}
