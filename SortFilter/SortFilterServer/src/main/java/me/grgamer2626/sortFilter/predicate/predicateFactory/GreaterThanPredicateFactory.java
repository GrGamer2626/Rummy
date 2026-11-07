package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;
import org.springframework.stereotype.Component;

@Component
public class GreaterThanPredicateFactory extends AbstractComparablePredicateFactory {

	@Override
	protected <Y extends Comparable<? super Y>> Predicate doApply(CriteriaBuilder criteriaBuilder, Path<Y> path, Y value) {
		return criteriaBuilder.greaterThan(path, value);
	}

	@Override
	public Operation supportedOperation() {
		return Operation.GREATER_THAN;
	}
}
