package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class EqualsPredicateFactory implements PredicateFactory<Object, Object> {

	@Override
	public Predicate create(CriteriaBuilder criteriaBuilder, Path<Object> path, Object value) {
		return criteriaBuilder.equal(path, value);
	}

	@Override
	public Operation supportedOperation() {
		return Operation.EQUAL;
	}
}
