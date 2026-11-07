package me.grgamer2626.sortFilter.dto.response;

import java.util.Collections;
import java.util.List;

public record PageResponse<T>(List<T> content, int pageNumber, int totalPages, int expectedSize, long totalElements, boolean last) {

	public static <R> PageResponse<R> empty(int size) {
		return new PageResponse<>(Collections.emptyList(), 0, 1, size, 1, true);
	}
}
