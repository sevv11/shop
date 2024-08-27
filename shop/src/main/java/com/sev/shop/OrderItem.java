package com.sev.shop;

import jakarta.persistence.ManyToOne;

public class OrderItem extends BaseEntity {
    @ManyToOne
    public Product product;
    public int quantity;
    @ManyToOne
    public Order order;
}
