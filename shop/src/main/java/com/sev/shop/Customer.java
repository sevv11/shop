package com.sev.shop;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity

public class Customer extends BaseEntity{
    public String name;
    public String email;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    public Cart cart;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    public List<Order> orders;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
