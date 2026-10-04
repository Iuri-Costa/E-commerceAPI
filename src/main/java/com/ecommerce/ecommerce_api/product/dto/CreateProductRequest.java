package com.ecommerce.ecommerce_api.product.dto;

import com.ecommerce.ecommerce_api.category.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank
        String name,

        @NotNull
        String description,

        @PositiveOrZero
        BigDecimal price,

        @PositiveOrZero
        int stock,

        @NotNull
        Category category
) {
}
