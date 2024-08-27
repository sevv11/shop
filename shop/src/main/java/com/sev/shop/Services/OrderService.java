package com.sev.shop.Services;

import com.sev.shop.Cart;
import com.sev.shop.Customer;
import com.sev.shop.Order;
import com.sev.shop.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    @Autowired
    public OrderRepository orderRepository;
    //metotlar gelecek
    public Order placeOrder(Customer customer, Cart cart) {

        Order order = new Order();
        return orderRepository.save(order);
    }
    public Order getOrderByCode(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }
    public List<Order> getAllOrdersForCustomer(Customer customer) {
        return orderRepository.findByCustomer(customer);
    }
}

//placeOrder: Yeni bir sipariş oluşturur.
//getOrderForCode: Sipariş koduna göre siparişi getirir.
//getAllOrdersForCustomer: Belirtilen müşteriye ait tüm siparişleri getirir.