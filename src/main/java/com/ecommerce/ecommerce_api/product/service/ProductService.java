package com.ecommerce.ecommerce_api.product.service;

import com.ecommerce.ecommerce_api.category.entity.Category;
import com.ecommerce.ecommerce_api.category.repository.CategoryRepository;
import com.ecommerce.ecommerce_api.product.dto.CreateProductRequest;
import com.ecommerce.ecommerce_api.product.dto.ProductResponse;
import com.ecommerce.ecommerce_api.product.entity.Product;
import com.ecommerce.ecommerce_api.product.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public ProductResponse create(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with Id: " + request.categoryId()));

        Product product = new Product(
                request.name(),
                request.description(),
                request.price(),
                request.stock(),
                category
        );

        product = productRepository.saveAndFlush(product);

        return ProductResponse.toResponse(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> list(int page, int limit, String search) {
        page = Math.max(page - 1, 0);
        limit = Math.min(Math.max(limit, 1), 50);

        Pageable pageable = PageRequest.of(page, limit, Sort.by("name").ascending());

        search = (search != null && !search.isBlank()) ? search.trim() : null;

        Page<Product> products = (search == null)
                ? productRepository.findAll(pageable)
                : productRepository.findByNameContainingIgnoreCase(search, pageable);

        return products.map(ProductResponse::toResponse);
    }
}
