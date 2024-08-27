package com.sev.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem extends BaseEntity {
    @ManyToMany
    private Product product;
    private int quantity;
    @ManyToOne
    private Cart cart;

    public Long getQuantity() {
    }

    public void setProduct(Product product) {
    }

    public void setQuantity(int i) {

    }
}
