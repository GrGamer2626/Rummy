package me.grgamer2626.sortFilter.predicate;

import me.grgamer2626.sortFilter.model.Operation;
import me.grgamer2626.sortFilter.predicate.predicateFactory.PredicateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PredicateFactoryRegistryImpl implements PredicateFactoryRegistry {

	private final Map<Operation, PredicateFactory<?, ?>> predicateFactoryMap = new ConcurrentHashMap<>();

	@Autowired
	public PredicateFactoryRegistryImpl(List<PredicateFactory<?,?>> predicateFactories) {
		predicateFactories.forEach(pf -> predicateFactoryMap.put(pf.supportedOperation(), pf));
	}

	@Override
	public PredicateFactory<?, ?> getPredicateFactory(Operation operation) {
		return predicateFactoryMap.get(operation);
	}
}
