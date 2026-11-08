package me.grgamer2626.sortFilter.utils;

import me.grgamer2626.sortFilter.exception.InvalidFilterValueException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

public final class FilterValueConverter {


	private FilterValueConverter() {
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static Object convert(Object rawValue, Class<?> targetType, String property) {
		if (rawValue == null) {
			return null;
		}

		if (targetType.isInstance(rawValue)) {
			return rawValue;
		}

		try {
			return convertSingle(rawValue, targetType);

		} catch (InvalidFilterValueException e) {
			throw e;

		} catch (Exception e) {
			throw new InvalidFilterValueException("Value '" + rawValue + "' for property '" + property + "' cannot be converted to " + targetType.getSimpleName());
		}
	}

	public static Collection<Object> convertCollection(Object rawValue, Class<?> targetType, String property) {
		if (!(rawValue instanceof Collection<?> rawCollection)) {
			throw new InvalidFilterValueException("Value for property '" + property + "' must be a list of values");
		}
		if (rawCollection.isEmpty()) {
			throw new InvalidFilterValueException("Value for property '" + property + "' must not be an empty list");
		}

		return rawCollection.stream()
				.map(value -> convert(value, targetType, property))
				.collect(Collectors.toList());
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static Object convertSingle(Object rawValue, Class<?> targetType) {
		String text = String.valueOf(rawValue);

		if (targetType == String.class) {
			return text;
		}
		if (targetType.isEnum()) {
			return toEnum(targetType, text);
		}
		if (targetType == Boolean.class || targetType == boolean.class) {
			return Boolean.parseBoolean(text);
		}
		if (targetType == Long.class || targetType == long.class) {
			return rawValue instanceof Number number ? number.longValue() : Long.parseLong(text);
		}
		if (targetType == Integer.class || targetType == int.class) {
			return rawValue instanceof Number number ? number.intValue() : Integer.parseInt(text);
		}
		if (targetType == Double.class || targetType == double.class) {
			return rawValue instanceof Number number ? number.doubleValue() : Double.parseDouble(text);
		}
		if (targetType == BigDecimal.class) {
			return new BigDecimal(text);
		}
		if (targetType == LocalDate.class) {
			return LocalDate.parse(text);
		}
		if (targetType == LocalDateTime.class) {
			return LocalDateTime.parse(text);
		}

		throw new InvalidFilterValueException("Unsupported filter target type " + targetType.getSimpleName());
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private static Object toEnum(Class<?> targetType, String text) {
		try {
			return Enum.valueOf((Class<Enum>) targetType, text);

		} catch (IllegalArgumentException e) {
			throw new InvalidFilterValueException("'" + text + "' is not a valid value of " + targetType.getSimpleName());
		}
	}
}
