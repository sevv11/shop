package com.sev.shop.Repositories;

import com.sev.shop.Customer;
import com.sev.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomer(Customer customer);
}
