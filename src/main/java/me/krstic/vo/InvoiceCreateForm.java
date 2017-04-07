package me.krstic.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvoiceCreateForm {

	private Integer clientId;
	private String number;
	private List<Integer> inputServiceId = new ArrayList<>();
	private List<Double> inputQuantity = new ArrayList<>();
	private Date invoiceDate;
	private String modifiedBy;
	
	public InvoiceCreateForm() {
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public List<Integer> getInputServiceId() {
		return inputServiceId;
	}

	public void setInputServiceId(List<Integer> inputServiceId) {
		this.inputServiceId = inputServiceId;
	}

	public List<Double> getInputQuantity() {
		return inputQuantity;
	}

	public void setInputQuantity(List<Double> inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "\"InvoiceCreateForm\": {\n\t\"clientId\": \"" + clientId + "\",\n\t\"number\": \"" + number
				+ "\",\n\t\"inputServiceId\": \"" + inputServiceId + "\",\n\t\"inputQuantity\": \"" + inputQuantity
				+ "\",\n\t\"invoiceDate\": \"" + invoiceDate + "\",\n\t\"modifiedBy\": \"" + modifiedBy + "\"\n}";
	}
}
