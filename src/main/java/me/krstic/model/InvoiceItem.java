package me.krstic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import me.krstic.idClass.InvoiceItemPK;

@Entity
@IdClass(InvoiceItemPK.class)
public class InvoiceItem {

	@Id
	@GeneratedValue
	private Integer id;
	@ManyToOne
	@Id
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	private Service service;
	private Double quantity;
	@ManyToOne
	@JoinColumn(name = "MEASUREMENT_ID")
	private Measurement measurement;
	
	public InvoiceItem() {
	}

	public InvoiceItem(Invoice invoice, Service service, Double quantity, Measurement measurement) {
		this.invoice = invoice;
		this.service = service;
		this.quantity = quantity;
		this.measurement = measurement;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Measurement getMeasurement() {
		return measurement;
	}

	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}

	@Override
	public String toString() {
		return "\"InvoiceItem\": {\n\t\"id\": \"" + id + "\",\n\t\"invoice\": \"" + invoice + "\",\n\t\"service\": \""
				+ service + "\",\n\t\"quantity\": \"" + quantity + "\",\n\t\"measurement\": \"" + measurement + "\"\n}";
	}
}
