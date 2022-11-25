package com.example.ProductCatlog.controller;

import com.example.ProductCatlog.model.Product;
import com.example.ProductCatlog.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    private ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok().body(this.productService.getProducts());
    }

    @GetMapping("/product/{prodId}")
    private Product getProductById(@PathVariable long prodId){
        return this.productService.getProdById(prodId);
    }

    @PostMapping("/products")
    private ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok().body(this.productService.createProd(product));
    }

    @PutMapping("/products/{prodId}")
    private ResponseEntity<Product> updateProduct(@PathVariable long prodId, @RequestBody Product product){
        product.setProdId(prodId);
        return ResponseEntity.ok().body(this.productService.updateProd(product));
    }

    @DeleteMapping("/products/{prodId}")
    private HttpStatus deleteProduct(@PathVariable long prodId){
        this.productService.deleteProd(prodId);
        return HttpStatus.OK;
    }

}
