package com.example.ProductCatlog.service;

import com.example.ProductCatlog.model.Product;

import java.util.List;

public interface ProductService {
    Product createProd(Product prod);
    Product updateProd(Product prod);
    List<Product> getProducts();
    Product getProdById(long prodId);
    void deleteProd(long prodId);

}
