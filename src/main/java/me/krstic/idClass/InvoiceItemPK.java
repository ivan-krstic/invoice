package me.krstic.idClass;

import java.io.Serializable;

import me.krstic.model.Invoice;

public class InvoiceItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Invoice invoice;
	
	public InvoiceItemPK() {
	}

	public InvoiceItemPK(Integer id, Invoice invoice) {
		this.id = id;
		this.invoice = invoice;
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

	@Override
	public String toString() {
		return "\"InvoiceItemPK\": {\n\t\"id\": \"" + id + "\",\n\t\"invoice\": \"" + invoice + "\"\n}";
	}
}
