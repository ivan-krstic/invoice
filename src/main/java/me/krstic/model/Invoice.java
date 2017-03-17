package me.krstic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String number;
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	private Client client;
	@OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<InvoiceItem> invoiceItems = new ArrayList<>();
	@Temporal(TemporalType.DATE)
	private Date modifiedOn;
	
	public Invoice() {
	}

	public Invoice(String number, Integer status, Client client, List<InvoiceItem> invoiceItems) {
		this.number = number;
		this.status = status;
		this.client = client;
		this.invoiceItems = invoiceItems;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	
	public List<InvoiceItem> addInvoiceItem(InvoiceItem invoiceItem) {
		invoiceItem.setInvoice(this);
		invoiceItems.add(invoiceItem);
		
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	@Override
	public String toString() {
		return "\"Invoice\": {\n\t\"id\": \"" + id + "\",\n\t\"number\": \"" + number + "\",\n\t\"status\": \"" + status
				+ "\",\n\t\"client\": \"" + client + "\",\n\t\"invoiceItems\": \"" + invoiceItems
				+ "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\"\n}";
	}
}
