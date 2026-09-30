package com.ecommerce.ecommerce_api.product.entity;

import com.ecommerce.ecommerce_api.category.entity.Category;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private int stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected Product() {}

    public Product(String name, String description, BigDecimal price, int stock, Category category) {
        this.name = name;
        this.description = description;

        if (price == null)
            throw new IllegalArgumentException("Price can't be null");

        if (price.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Price can't be negative");

        this.price = price;

        if (stock < 0)
            throw new  IllegalArgumentException("Stock can't be negative");

        this.stock = stock;

        if (category == null)
            throw new IllegalArgumentException("Category can't be null");

        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
