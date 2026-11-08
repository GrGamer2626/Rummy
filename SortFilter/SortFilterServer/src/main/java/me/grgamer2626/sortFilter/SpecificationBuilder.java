package me.grgamer2626.sortFilter;

import jakarta.validation.constraints.NotNull;
import me.grgamer2626.sortFilter.model.SqlFilter;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface SpecificationBuilder<T> {

	@NotNull Specification<@NonNull T> buildSpecification(@NotNull List<SqlFilter> filters);

}
