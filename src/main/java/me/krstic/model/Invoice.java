package me.krstic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.NONE)
public class Invoice {

	@Id
	@GeneratedValue
	private Integer id;
	@XmlElement
	private String number;
	private Integer status;
	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	@XmlElement
	private Client client;
	@OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@XmlElement
	private List<InvoiceItem> invoiceItems = new ArrayList<>();
	@Temporal(TemporalType.DATE)
	@XmlElement
	private Date invoiceDate;
	@XmlElement
	private Double totalWithoutTax;
	@XmlElement
	private Double tax;
	@XmlElement
	private Double total;
	@ManyToOne
	@JoinColumn(name = "OWNER_ID")
	@XmlElement
	private Owner owner;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User modifiedBy;
	
	public Invoice() {
	}

	public Invoice(String number, Client client, Date invoiceDate, User modifiedBy) {
		this.number = number;
		this.client = client;
		this.invoiceDate = invoiceDate;
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

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Double getTotalWithoutTax() {
		return totalWithoutTax;
	}

	public void setTotalWithoutTax(Double totalWithoutTax) {
		this.totalWithoutTax = totalWithoutTax;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
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
		return "\"Invoice\": {\n\t\"id\": \"" + id + "\",\n\t\"number\": \"" + number + "\",\n\t\"status\": \"" + status
				+ "\",\n\t\"client\": \"" + client + "\",\n\t\"invoiceItems\": \"" + invoiceItems
				+ "\",\n\t\"invoiceDate\": \"" + invoiceDate + "\",\n\t\"totalWithoutTax\": \"" + totalWithoutTax
				+ "\",\n\t\"tax\": \"" + tax + "\",\n\t\"total\": \"" + total + "\",\n\t\"owner\": \"" + owner
				+ "\",\n\t\"modifiedOn\": \"" + modifiedOn + "\",\n\t\"modifiedBy\": \"" + modifiedBy + "\"\n}";
	}
}
