package me.krstic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import me.krstic.idClass.InvoiceItemPK;

@Entity
@IdClass(InvoiceItemPK.class)
public class InvoiceItem {

	@Id
	private Integer id;
	@ManyToOne
	@Id
	@JoinColumn(name = "INVOICE_ID")
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "SERVICE_ID")
	private Service service;
	private Double quantity;
	@Transient
	private Double total;
	
	public InvoiceItem() {
	}

	public InvoiceItem(Invoice invoice, Service service, Double quantity) {
		this.invoice = invoice;
		this.service = service;
		this.quantity = quantity;
	}
	
	@PostLoad
	private void onLoad() {
	    this.total = service.getPrice() * quantity;
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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "\"InvoiceItem\": {\n\t\"id\": \"" + id + "\",\n\t\"invoice\": \"" + invoice + "\",\n\t\"service\": \""
				+ service + "\",\n\t\"quantity\": \"" + quantity + "\",\n\t\"total\": \"" + total + "\"\n}";
	}
}
