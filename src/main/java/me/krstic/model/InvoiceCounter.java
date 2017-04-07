package me.krstic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InvoiceCounter {
	
	private static InvoiceCounter instance = null;

	@Id
	@GeneratedValue
	private Integer id;
	@Column(name = "VALUE", unique = true)
	private Integer value;
	
	private InvoiceCounter() {
	}
	
	public static synchronized InvoiceCounter getInstance() {
		if (instance == null) {
			instance = new InvoiceCounter();
		}
		return instance;
	}
	
	public int getCurrentValue() {
		return value;
	}
	
	public int create() {
		return ++value;
	}
	
	public int remove() {
		return --value;
	}
}
