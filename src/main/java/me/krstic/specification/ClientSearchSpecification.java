package me.krstic.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.krstic.model.Client;

public class ClientSearchSpecification {
	
	public static Specification<Client> hasName(String name) {
		return new Specification<Client>() {
			public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (name != null && !name.isEmpty()) {
					return builder.like(builder.upper(root.get("name")), "%"+name.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Client> hasZipCode(String zipCode) {
		return new Specification<Client>() {
			public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (zipCode != null && !zipCode.isEmpty()) {
					return builder.equal(root.get("zipCode"), zipCode);
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Client> hasCity(String city) {
		return new Specification<Client>() {
			public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (city != null && !city.isEmpty()) {
					return builder.like(builder.upper(root.get("city")), "%"+city.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<Client> hasStreet(String street) {
		return new Specification<Client>() {
			public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (street != null && !street.isEmpty()) {
					return builder.like(builder.upper(root.get("street")), "%"+street.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
}
