package com.sev.shop.Services;

import com.sev.shop.Cart;
import com.sev.shop.Customer;
import com.sev.shop.Product;
import com.sev.shop.Repositories.CartItemRepository;
import com.sev.shop.Repositories.CartRepository;
import com.sev.shop.Repositories.CustomerRepository;
import com.sev.shop.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CartService {
    private Long id;

    public CartService(CartRepository cartRepository, Long id, CartItemRepository cartItemRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.id = id;
        this.cartItemRepository = cartItemRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }
    @Autowired

    private final CartItemRepository cartItemRepository;

    @Autowired
    private final CustomerRepository customerRepository;
    @Autowired
    private final ProductRepository productRepository;

    public void removeProductFromCart(Cart cart, Product product) {

    }

    public void addProductToCart(Cart cart, Product product, int quantity) {

            }


    public void emptyCart(Cart cart) {
        cart.getItems().clear();
        cart.setTotalPrice(0);
        CartRepository.save(cart);
    }



    public Cart updateCart(Long cart) {

        return CartRepository.save(cart);
    }

    public Cart getCartByCustomer(Customer customer) {
        return CartRepository.findByCustomer(customer);
    }


}


