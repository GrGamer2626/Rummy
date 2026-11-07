package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class IsNotNullPredicateFactory implements PredicateFactory<Object, Object> {

	@Override
	public Predicate create(CriteriaBuilder criteriaBuilder, Path<Object> path, Object value) {
		return criteriaBuilder.isNotNull(path);
	}

	@Override
	public Operation supportedOperation() {
		return Operation.IS_NOT_NULL;
	}
}
