package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class InPredicateFactory implements PredicateFactory<Object, Collection<Object>> {

	@Override
	public Predicate create(CriteriaBuilder criteriaBuilder, Path<Object> path, Collection<Object> value) {
		return path.in(value);
	}

	@Override
	public Operation supportedOperation() {
		return Operation.IN;
	}
}