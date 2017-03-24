package me.krstic.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.krstic.model.Client;
import me.krstic.model.Invoice;

public class InvoiceSearchSpecification {
	
	public static Specification<Invoice> hasClientName(String clientName) {
		return new Specification<Invoice>() {
			public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (clientName != null && !clientName.isEmpty()) {
					Join<Invoice, Client> client = root.join("client");
					return builder.like(builder.upper(client.get("name")), "%"+clientName.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Invoice> hasInvoiceDateFrom(Date invoiceDateFrom) {
		return new Specification<Invoice>() {
			public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (invoiceDateFrom != null) {
					return builder.greaterThanOrEqualTo(root.<Date>get("invoiceDate"), invoiceDateFrom);
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Invoice> hasInvoiceDateTo(Date invoiceDateTo) {
		return new Specification<Invoice>() {
			public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (invoiceDateTo != null) {
					return builder.lessThanOrEqualTo(root.<Date>get("invoiceDate"), invoiceDateTo);
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Invoice> hasStatus(Integer status) {
		return new Specification<Invoice>() {
			public Predicate toPredicate(Root<Invoice> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (status != null) {
					return builder.equal(root.get("status"), status);
				} else {
					return null;
				}
			}
		};
	}
}
