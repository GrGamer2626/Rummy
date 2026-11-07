package me.grgamer2626.sortFilter.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SqlFilter(@NotBlank String properties, @NotNull Operation operation, Object value) {
}
