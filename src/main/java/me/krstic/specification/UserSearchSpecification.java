package me.krstic.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import me.krstic.model.User;

public class UserSearchSpecification {

	public static Specification<User> hasName(String name) {
		return new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (name != null && !name.isEmpty()) {
					return builder.like(builder.upper(root.get("name")), "%"+name.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
	
	public static Specification<User> hasUsername(String username) {
		return new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (username != null && !username.isEmpty()) {
					return builder.like(builder.upper(root.get("username")), "%"+username.toUpperCase()+"%");
				} else {
					return null;
				}
			}
		};
	}
}
