package me.grgamer2626.sortFilter;

import jakarta.validation.constraints.NotNull;
import me.grgamer2626.sortFilter.model.SortDirection;
import org.springframework.data.domain.Sort;


public interface SortBuilder<T> {

    @NotNull Sort buildSort(String sortBy, SortDirection sortDirection);

}
