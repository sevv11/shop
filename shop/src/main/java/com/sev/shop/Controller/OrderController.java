package com.sev.shop.Controller;

import com.sev.shop.Cart;
import com.sev.shop.Customer;
import com.sev.shop.Order;
import com.sev.shop.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(@RequestParam Long customerId) {
        Customer customer = CustomerService.getCustomerById(customerId).orElse(null);
        Cart cart = CartService.getCartByCustomer(customer);
        return orderService.placeOrder(customer, cart);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrderByCode(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersForCustomer(@PathVariable Long customerId) {
        Customer customer = CustomerService.getCustomerById(customerId).orElse(null);
        return orderService.getAllOrdersForCustomer(customer);
    }
}
