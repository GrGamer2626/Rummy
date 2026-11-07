package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;

public abstract class AbstractComparablePredicateFactory implements PredicateFactory<Comparable<?>, Comparable<?>> {

	@Override
	public Predicate create(CriteriaBuilder criteriaBuilder, Path<Comparable<?>> path, Comparable<?> value) {
		return bridge(criteriaBuilder, path, value);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	private Predicate bridge(CriteriaBuilder criteriaBuilder, Path path, Comparable value) {
		return doApply(criteriaBuilder, path, value);
	}

	protected abstract <Y extends Comparable<? super Y>> Predicate doApply(CriteriaBuilder criteriaBuilder, Path<Y> path, Y value);
}
