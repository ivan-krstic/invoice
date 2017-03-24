package me.krstic.vo;

import java.util.Date;
import java.util.List;

import me.krstic.model.InvoiceItem;

public class InvoiceCreateForm {

	private Integer id;
	private String number;
	private Integer clientId;
	private Integer serviceId;
	private Double quantity;
	private Double price;
	private Double total;
	private List<InvoiceItem> invoiceItems;
	private Date invoiceDate;
	
	public InvoiceCreateForm() {
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

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public List<InvoiceItem> getInvoiceItems() {
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "\"InvoiceCreateForm\": {\n\t\"id\": \"" + id + "\",\n\t\"number\": \"" + number
				+ "\",\n\t\"clientId\": \"" + clientId + "\",\n\t\"serviceId\": \"" + serviceId
				+ "\",\n\t\"quantity\": \"" + quantity + "\",\n\t\"price\": \"" + price + "\",\n\t\"total\": \"" + total
				+ "\",\n\t\"invoiceItems\": \"" + invoiceItems + "\",\n\t\"invoiceDate\": \"" + invoiceDate + "\"\n}";
	}
}
