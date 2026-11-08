package me.grgamer2626.sortFilter;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.NotNull;
import me.grgamer2626.sortFilter.exception.InvalidPropertyException;
import me.grgamer2626.sortFilter.model.Operation;
import me.grgamer2626.sortFilter.model.SortDirection;
import me.grgamer2626.sortFilter.model.SqlFilter;
import me.grgamer2626.sortFilter.predicate.PredicateFactoryRegistry;
import me.grgamer2626.sortFilter.predicate.predicateFactory.PredicateFactory;
import me.grgamer2626.sortFilter.utils.FilterValueConverter;
import me.grgamer2626.sortFilter.utils.PropertyPathResolver;
import org.jspecify.annotations.NonNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public abstract class SortFilterBuilder<@NotNull T> implements SpecificationBuilder<T>, SortBuilder<T> {
	private final Class<T> entityType;
	private final PredicateFactoryRegistry predicateFactoryRegistry;

	public SortFilterBuilder(Class<T> entityClass, PredicateFactoryRegistry predicateFactoryRegistry) {
		this.entityType = entityClass;
		this.predicateFactoryRegistry = predicateFactoryRegistry;
	}

	@Override
	public @NotNull Specification<@NonNull T> buildSpecification(List<SqlFilter> filters) {
		if (filters == null || filters.isEmpty()) {
			return Specification.unrestricted();
		}

		return (root, query, criteriaBuilder) -> {
			query.distinct(true);

			List<Predicate> predicates = filters.stream()
					.map(filter -> toPredicate(filter, root, criteriaBuilder))
					.toList();

			return criteriaBuilder.and(predicates);
		};
	}

	@Override
	public @NotNull Sort buildSort(String sortBy, SortDirection sortDirection) {
		if (sortBy == null || sortBy.isBlank() || sortDirection == null) {
			return Sort.unsorted();
		}

		Direction direction = resolveDirection(sortDirection);
		if (direction == null) {
			return Sort.unsorted();
		}

		Class<?> propertyType = PropertyPathResolver.resolveType(entityType, sortBy);
		if (!propertyType.isPrimitive() && !Comparable.class.isAssignableFrom(propertyType)) {
			throw new InvalidPropertyException("Cannot sort by '" + sortBy + "': type " + propertyType.getSimpleName() + " is not sortable");
		}

		return Sort.by(direction, sortBy);
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("unchecked")
	private Predicate toPredicate(SqlFilter filter, Root<T> root, CriteriaBuilder criteriaBuilder) {
		Class<?> propertyType = PropertyPathResolver.resolveType(entityType, filter.properties());
		if (!isApplicable(filter.operation(), propertyType)) {
			throw new IllegalArgumentException("Operation " + filter.operation() + " cannot be applied to property '" + filter.properties() + "' of type " + propertyType.getSimpleName());
		}

		Object convertedValue = convertValue(filter, propertyType);
		PredicateFactory<Object, Object> predicateFactory = (PredicateFactory<Object, Object>) resolvePredicateFactory(filter.operation());
		Path<Object> path = (Path<Object>) PropertyPathResolver.resolvePath(root, entityType, filter.properties());

		return predicateFactory.create(criteriaBuilder, path, convertedValue);
	}

	private Object convertValue(SqlFilter filter, Class<?> propertyType) {
		Operation operation = filter.operation();
		if (operation == Operation.IS_NULL || operation == Operation.IS_NOT_NULL) {
			return null;
		}

		if (operation == Operation.IN) {
			return FilterValueConverter.convertCollection(filter.value(), propertyType, filter.properties());
		}

		return FilterValueConverter.convert(filter.value(), propertyType, filter.properties());
	}

	private PredicateFactory<?, ?> resolvePredicateFactory(Operation operation) {
		PredicateFactory<?, ?> factory = predicateFactoryRegistry.getPredicateFactory(operation);
		if (factory == null) {
			throw new IllegalArgumentException("No PredicateFactory registered for operation " + operation);
		}

		return factory;
	}

	private boolean isApplicable(Operation operation, Class<?> propertyType) {
		return switch (operation) {
			case LIKE, NOT_LIKE -> CharSequence.class.isAssignableFrom(propertyType);
			case GREATER_THAN, GREATER_OR_EQUAL_THAN, LESS_THAN, LESS_OR_EQUAL_THAN -> Comparable.class.isAssignableFrom(propertyType);
			case EQUAL, NOT_EQUAL, IN, IS_NULL, IS_NOT_NULL -> true;
		};
	}

	private Direction resolveDirection(SortDirection sortDirection) {
		switch (sortDirection) {
            case ASCENDING -> {
				return Direction.ASC;
            }
            case DESCENDING -> {
				return Direction.DESC;
            }
			default -> {
				return null;
			}
        }
	}
}
