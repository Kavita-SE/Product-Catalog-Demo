package com.example.ProductCatlog.repository;

import com.example.ProductCatlog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
