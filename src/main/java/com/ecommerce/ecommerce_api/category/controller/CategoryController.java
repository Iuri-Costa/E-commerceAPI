package com.ecommerce.ecommerce_api.category.controller;

import com.ecommerce.ecommerce_api.category.dto.CategoryResponse;
import com.ecommerce.ecommerce_api.category.dto.CreateCategoryRequest;
import com.ecommerce.ecommerce_api.category.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody @Valid CreateCategoryRequest request) {
        CategoryResponse response = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
