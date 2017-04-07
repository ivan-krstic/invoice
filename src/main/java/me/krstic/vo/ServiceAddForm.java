package me.krstic.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ServiceAddForm {

	private Integer id;
	@NotEmpty(message = "Service name is empty.")
	private String name;
	@NotNull(message = "Service price is empty.")
	private Double price;
	@NotNull(message = "Service measurement is empty.")
	private Integer measurementId;
	private String modifiedBy;
	
	public ServiceAddForm() {
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMeasurementId() {
		return measurementId;
	}

	public void setMeasurementId(Integer measurementId) {
		this.measurementId = measurementId;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "\"ServiceAddForm\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"price\": \""
				+ price + "\",\n\t\"measurementId\": \"" + measurementId + "\",\n\t\"modifiedBy\": \"" + modifiedBy
				+ "\"\n}";
	}
}
