package me.krstic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Counter {

	@Id
	@GeneratedValue
	private Integer id;
	@Column(unique = true)
	private String name;
	private Integer value;
	
	public Counter() {
	}
	
	public Counter(String name) {
		this.name = name;
		this.value = 0;
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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "\"Counter\": {\n\t\"id\": \"" + id + "\",\n\t\"name\": \"" + name + "\",\n\t\"value\": \"" + value
				+ "\"\n}";
	}
}
