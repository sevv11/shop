package com.sev.shop;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;




@Entity
public class Cart extends BaseEntity{
    @OneToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;

public Customer getCustomer() {
    return customer;
}

public void setCustomer(Customer customer) {
    this.customer = customer;
}
    @ManyToOne

    @OneToMany(mappedBy = "cart")
    public List<CartItem> cartItems;

    public Collection<Object> getItems() {
    }

    public void setTotalPrice(double v) {
    }

    public double getTotalPrice() {
        return 0;
    }
}