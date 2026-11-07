package me.grgamer2626.sortFilter.predicate;

import me.grgamer2626.sortFilter.model.Operation;
import me.grgamer2626.sortFilter.predicate.predicateFactory.PredicateFactory;

public interface PredicateFactoryRegistry {

	PredicateFactory<?, ?> getPredicateFactory(Operation operation);

}
