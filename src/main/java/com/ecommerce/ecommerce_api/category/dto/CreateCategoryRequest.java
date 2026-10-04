package com.ecommerce.ecommerce_api.category.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
        @NotBlank
        String name
) {
}
