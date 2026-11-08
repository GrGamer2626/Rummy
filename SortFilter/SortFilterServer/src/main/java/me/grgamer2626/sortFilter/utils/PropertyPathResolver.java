package me.grgamer2626.sortFilter.utils;

import jakarta.persistence.criteria.From;
import jakarta.persistence.criteria.Path;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import me.grgamer2626.sortFilter.exception.InvalidPropertyException;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public final class PropertyPathResolver {


	private PropertyPathResolver() {
	}

	/**
	 * @throws InvalidPropertyException if any segment of {@code property} does not correspond to an existing field
	 * on the traversed entity graph.
	 */
	public static Class<?> resolveType(@NotNull Class<?> rootEntity, @NotBlank String property) {
		Class<?> currentType = rootEntity;
		for (String segment : property.split("\\.")) {
			Field field = findField(currentType, segment, property);
			currentType = Collection.class.isAssignableFrom(field.getType()) ? resolveCollectionElementType(field, property) : field.getType();
		}
		return currentType;
	}

	/**
	 * @throws InvalidPropertyException if any segment of {@code property} does not correspond to an existing field
	 * on the traversed entity graph.
	 */
	public static Path<?> resolvePath(@NotNull From<?, ?> root, @NotNull Class<?> rootEntity, @NotBlank String property) {
		String[] segments = property.split("\\.");
		From<?, ?> currentFrom = root;
		Class<?> currentType = rootEntity;

		for (int i = 0; i < segments.length; i++) {
			String segment = segments[i];
			boolean isLastSegment = i == segments.length - 1;
			Field field = findField(currentType, segment, property);

			if (Collection.class.isAssignableFrom(field.getType())) {
				From<?, ?> joined = currentFrom.join(segment);
				if (isLastSegment) {
					return joined;
				}
				currentFrom = joined;
				currentType = resolveCollectionElementType(field, property);
			} else {
				if (isLastSegment) {
					return currentFrom.get(segment);
				}
				currentFrom = (From<?, ?>) currentFrom.get(segment);
				currentType = field.getType();
			}
		}

		throw new InvalidPropertyException("Filter property '" + property + "' could not be resolved");
	}

	private static Field findField(@NotNull Class<?> type, @NotNull  String segment, @NotNull String fullProperty) {
		Assert.notNull(type, "Class type can not be null.");
		Class<?> current = type;
		while (current != null && current != Object.class) {
			try {
				return current.getDeclaredField(segment);
			} catch (NoSuchFieldException ignored) {
				current = current.getSuperclass();
			}
		}

		throw new InvalidPropertyException("Unknown filter property '" + segment + "' (in '" + fullProperty + "') for type " + type.getSimpleName());
	}

	private static Class<?> resolveCollectionElementType(@NotNull Field field, @NotNull  String fullProperty) {
		Type genericType = field.getGenericType();
		if (genericType instanceof ParameterizedType parameterizedType) {
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			if (typeArguments.length == 1 && typeArguments[0] instanceof Class<?> elementType) {
				return elementType;
			}
		}

		throw new InvalidPropertyException("Could not determine element type of collection property '" + fullProperty + "'");
	}
}
