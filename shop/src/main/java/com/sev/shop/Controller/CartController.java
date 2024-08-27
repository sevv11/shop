package com.sev.shop.Controller;

import com.sev.shop.Cart;
import com.sev.shop.Product;
import com.sev.shop.Services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping


public class CartController {
@Autowired
    private CartService cartService;
    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long customerId) {
        Cart cart = cartService.getCart(customerId);
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/{customerId}/updateCart")
    public ResponseEntity<Cart> updateCart(@PathVariable Long customerId) {
        Cart updatedCart = cartService.updateCart(customerId);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{customerId}/emptyCart")
    public ResponseEntity<Void> emptyCart(@PathVariable Long customerId) {
        cartService.emptyCart(Cart cart);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{customerId}/addProductToCart")
    public ResponseEntity<Cart> addProductToCart(
            @PathVariable Long customerId,
            @RequestBody Long productId) {
        Cart updatedCart = cartService.addProductToCart( Cart cart,Product product);
        return ResponseEntity.ok(updatedCart);
    }

    @DeleteMapping("/{customerId}/removeProductFromCart")
    public ResponseEntity<Cart> removeProductFromCart(
            @PathVariable Long customerId,
            @RequestBody Long productId ) {
        Cart updatedCart = cartService.removeProductFromCart(Cart cart, Product product);
        return ResponseEntity.ok(updatedCart);
    }




}
