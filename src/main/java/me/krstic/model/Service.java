package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Double price;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	
	public Service() {
	}

	public Service(String name, Double price) {
		this.name = name;
		this.price = price;
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

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "\"Service\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"price\": \"" + price
				+ "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\"\n}";
	}
}
