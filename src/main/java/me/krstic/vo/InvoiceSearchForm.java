package me.krstic.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class InvoiceSearchForm {

	private String clientName;
	@DateTimeFormat(pattern = "dd-MMM-yy")
	private Date invoiceDateFrom;
	@DateTimeFormat(pattern = "dd-MMM-yy")
	private Date invoiceDateTo;
	private Integer status;
	
	public InvoiceSearchForm() {
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getInvoiceDateFrom() {
		return invoiceDateFrom;
	}

	public void setInvoiceDateFrom(Date invoiceDateFrom) {
		this.invoiceDateFrom = invoiceDateFrom;
	}

	public Date getInvoiceDateTo() {
		return invoiceDateTo;
	}

	public void setInvoiceDateTo(Date invoiceDateTo) {
		this.invoiceDateTo = invoiceDateTo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\"InvoiceSearchForm\": {\n\t\"clientName\": \"" + clientName + "\",\n\t\"invoiceDateFrom\": \""
				+ invoiceDateFrom + "\",\n\t\"invoiceDateTo\": \"" + invoiceDateTo + "\",\n\t\"status\": \"" + status
				+ "\"\n}";
	}
}
