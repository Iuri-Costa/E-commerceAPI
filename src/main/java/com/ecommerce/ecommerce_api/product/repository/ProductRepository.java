package com.ecommerce.ecommerce_api.product.repository;

import com.ecommerce.ecommerce_api.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {}
