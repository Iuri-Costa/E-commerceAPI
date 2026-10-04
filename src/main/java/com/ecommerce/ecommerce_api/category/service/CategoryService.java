package com.ecommerce.ecommerce_api.category.service;

import com.ecommerce.ecommerce_api.category.dto.CategoryResponse;
import com.ecommerce.ecommerce_api.category.dto.CreateCategoryRequest;
import com.ecommerce.ecommerce_api.category.entity.Category;
import com.ecommerce.ecommerce_api.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public CategoryResponse create(CreateCategoryRequest request) {
        repository.findByName(request.name())
                .ifPresent(category ->
                        new IllegalStateException("Category already exists with Name: " + request.name()));

        Category category = new Category(request.name());

        repository.save(category);

        return new CategoryResponse(category.getId(), category.getName());
    }
}
