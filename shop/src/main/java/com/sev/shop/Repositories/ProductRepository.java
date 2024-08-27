package com.sev.shop.Repositories;

import com.sev.shop.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long >
{

}
