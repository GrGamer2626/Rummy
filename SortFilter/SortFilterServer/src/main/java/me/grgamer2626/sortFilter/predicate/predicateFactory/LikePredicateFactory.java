package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class LikePredicateFactory implements PredicateFactory<String, String> {

	@Override
	public Predicate create(CriteriaBuilder criteriaBuilder, Path<String> path, String value) {
		return criteriaBuilder.like(path, value);
	}

	@Override
	public Operation supportedOperation() {
		return Operation.LIKE;
	}
}
