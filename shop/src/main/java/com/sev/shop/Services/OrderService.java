package com.sev.shop.Services;

import com.sev.shop.*;
import com.sev.shop.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;


    @Transactional

    public Order placeOrder(Customer customer, Cart cart) {


        Order order = new Order();
        order.setCustomer(customer);
        order.setCart(cart);
        for (Object cartItem : cart.getItems()) {
            Product product = cartItem.getProduct();
            int quantity = Math.toIntExact(CartItem.getQuantity());


            if (product.getStock() < quantity) {
                throw new IllegalStateException("Product " + product.getName() + " stokta yok");
            }

            product.setStock(product.getStock() - quantity);// Stok azaltma


            ProductService.updateProduct(product);// guncel urunu veritabaninda kaydet
        }


        orderRepository.save(order);
        cartService.emptyCart(cart);
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