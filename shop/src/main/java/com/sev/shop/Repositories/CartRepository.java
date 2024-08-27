package com.sev.shop.Repositories;

import com.sev.shop.Cart;
import com.sev.shop.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    static Cart findByCustomer(Customer customer) {


    static Cart save(Long cart) {
            return null;
    }
}
