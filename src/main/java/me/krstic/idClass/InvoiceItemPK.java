package me.krstic.idClass;

import java.io.Serializable;

public class InvoiceItemPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer invoiceId;
	
	public InvoiceItemPK() {
	}

	public InvoiceItemPK(Integer id, Integer invoiceId) {
		this.id = id;
		this.invoiceId = invoiceId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((invoiceId == null) ? 0 : invoiceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceItemPK other = (InvoiceItemPK) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (invoiceId == null) {
			if (other.invoiceId != null)
				return false;
		} else if (!invoiceId.equals(other.invoiceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\"InvoiceItemPK\": {\n\t\"id\": \"" + id + "\",\n\t\"invoiceId\": \"" + invoiceId + "\"\n}";
	}
}
