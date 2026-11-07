package me.grgamer2626.sortFilter.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import me.grgamer2626.sortFilter.model.SortDirection;
import me.grgamer2626.sortFilter.model.SqlFilter;

import java.util.List;

public record SearchRequest(List<@Valid SqlFilter> filters, @Min(0) int page, @Min(1) int size, String sortBy, SortDirection sortDirection) {
}
