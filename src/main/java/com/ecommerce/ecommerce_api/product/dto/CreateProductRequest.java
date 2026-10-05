package com.ecommerce.ecommerce_api.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateProductRequest(
        @NotBlank
        String name,

        String description,

        @NotNull
        @PositiveOrZero
        BigDecimal price,

        @PositiveOrZero
        int stock,

        @NotNull
        UUID categoryId
) {
}
