package me.grgamer2626.sortFilter.predicate.predicateFactory;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import me.grgamer2626.sortFilter.model.Operation;

public interface PredicateFactory<P, V> {

	Predicate create(CriteriaBuilder criteriaBuilder, Path<P> path, V value);

	Operation supportedOperation();

}
