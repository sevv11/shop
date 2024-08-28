package com.sev.shop.Services;

import com.sev.shop.Product;
import com.sev.shop.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);

    }

    public static Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);

    }
    public static void updateProduct(Product product) {
        productRepository.save(product);
    }

    public static void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product id ile bulunamadı: " + id));
    }




}
