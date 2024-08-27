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

    public static List<Product> getAllProducts() {
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);

    }

    public static Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);

    }
    public static Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    public static void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}
