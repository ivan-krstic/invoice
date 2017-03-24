package me.krstic.vo;

public class ServiceAddForm {

	private Integer id;
	private String name;
	private Double price;
	private Integer measurementId;
	
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

	@Override
	public String toString() {
		return "\"ServiceAddForm\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"price\": \""
				+ price + "\",\n\t\"measurementId\": \"" + measurementId + "\"\n}";
	}
}
