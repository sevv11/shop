package com.sev.shop.Services;

import com.sev.shop.Cart;
import com.sev.shop.CartItem;
import com.sev.shop.Customer;
import com.sev.shop.Product;
import com.sev.shop.Repositories.CartItemRepository;
import com.sev.shop.Repositories.CartRepository;
import com.sev.shop.Repositories.CustomerRepository;
import com.sev.shop.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductService productService;


    @Transactional
    public Cart createCart(Customer customer){
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setTotalPrice(0.0);
        return cartRepository.save(cart);
    }

    private Long cartId;

   // public CartService(CartRepository cartRepository, Long id, CartItemRepository cartItemRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
      //  this.id = id;
     //   this.cartItemRepository = cartItemRepository;
      //  this.customerRepository = customerRepository;
      //  this.productRepository = productRepository;
   // }


    public void removeProductFromCart(Cart cartId, Product productId) {
        Cart cart = getCartById(cartId);
        cart.getCartItems().removeIf(item ->item.getProduct(.getId()
                .equals(productId));
        updateCartTotalPrice(cart);
        return CartRepository.save(cart);

    }

    public void addProductToCart(Cart cart, Product product, int quantity) {
        Cart cart = getCartById(cartId);
        Product product = ProductService.getProduct(productId);
        Optional<CartItem> existingCartItem = cart.getItems().stream()
                .filter(item -> item.getProduct(.getId().equals(productId))
                .findFirst();
                if (existingCartItem.isPresent()) {
                    CartItem cartItem = existingCartItem.get();
                    cartItem.setQuantity(cartItem.getQuantity() + quantity);
                }else {
                    CartItem cartItem = new CartItem();
                    cartItem.setProduct(product);
                    cartItem.setQuantity(quantity);
                    cartItem.setCart(cart);
                    cart.getItems().add(cartItem);
                }
                updateCartTotalPrice(cart);
                return CartRepository.save(cart);

    }


    public void emptyCart(Cart cart) {
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        CartRepository.save(cart);
    }



    public Cart updateCart(Long cart) {

        return CartRepository.save(cart);
    }

    public Cart getCartByCustomer(Customer customer) {
        return CartRepository.findByCustomer(customer);
    }
    public Cart getCartById(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found with id: " + cartId));
    }
    private void updateCartTotalPrice(Cart cart) {
        double totalPrice = cart.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
    }


    public Cart getCart(Long customerId) {
        return null;
    }
}


