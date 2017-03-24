package me.krstic.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.krstic.model.Service;

public class ServiceSearchSpecification {
	
	public static Specification<Service> hasName(String name) {
		return new Specification<Service>() {
			public Predicate toPredicate(Root<Service> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (name != null && !name.isEmpty()) {
					return builder.like(builder.upper(root.get("name")), "%"+name.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
}
