package com.ecommerce.ecommerce_api.order.entity;

import com.ecommerce.ecommerce_api.product.entity.Product;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal price;

    protected OrderItem() {}

    public OrderItem(Order order, Product product, int quantity) {
        if (order == null)
            throw new IllegalArgumentException("Order can't be null");

        this.order = order;

        if (product == null)
            throw new IllegalArgumentException("Product can't be null");

        this.product = product;

        if(quantity <= 0)
            throw new IllegalArgumentException("Quantity can't be negative or 0");

        this.quantity = quantity;

        this.price = product.getPrice();
    }

    public BigDecimal calculateTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
