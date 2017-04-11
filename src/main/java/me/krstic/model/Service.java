package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "service")
@XmlAccessorType(XmlAccessType.NONE)
public class Service {

	@Id
	@GeneratedValue
	private Integer id;
	@XmlElement
	private String name;
	@XmlElement
	private Double price;
	@ManyToOne
	@JoinColumn(name = "MEASUREMENT_ID")
	@XmlElement
	private Measurement measurement;
	private Integer status;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User modifiedBy;
	
	public Service() {
	}

	public Service(String name, Double price, Measurement measurement, User modifiedBy) {
		this.name = name;
		this.price = price;
		this.measurement = measurement;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
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
		return "\"Service\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"price\": \"" + price
				+ "\",\n\t\"measurement\": \"" + measurement + "\",\n\t\"status\": \"" + status
				+ "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\",\n\t\"modifiedBy\": \"" + modifiedBy + "\"\n}";
	}
}
