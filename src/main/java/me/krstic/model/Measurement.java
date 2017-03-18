package me.krstic.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Measurement {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String desciption;
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	
	public Measurement() {
	}

	public Measurement(String name, String desciption) {
		this.name = name;
		this.desciption = desciption;
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

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "\"Measurement\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"desciption\": \""
				+ desciption + "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\"\n}";
	}
}
