package com.example.ProductCatlog.service;

import com.example.ProductCatlog.exception.ProductException;
import com.example.ProductCatlog.model.Product;
import com.example.ProductCatlog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProd(Product prod){
        return productRepository.save(prod);
    }

    @Override
    public Product updateProd(Product prod) {
        Optional<Product> prodObj = this.productRepository.findById(prod.getProdId());

        if (prodObj.isPresent()) {
            Product prodUpdate = prodObj.get();
            prodUpdate.setProdId(prod.getProdId());
            prodUpdate.setProdName(prod.getProdName());
            prodUpdate.setProdQty(prod.getProdQty());
            return this.productRepository.save(prodUpdate);
        }
        else
            throw new ProductException("Product didn't found with ID: " + prod.getProdId());
    }

    @Override
    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    @Override
    public Product getProdById(long prodId){
        Optional<Product> prodObj = this.productRepository.findById(prodId);
        if(prodObj.isPresent()){
            return prodObj.get();
        }
        else
            throw new ProductException("Product didn't found with ID: " + prodId);
    }

    @Override
    public void deleteProd(long prodId){
        Optional<Product> prodObj = this.productRepository.findById(prodId);
        if(prodObj.isPresent()){
            this.productRepository.deleteById(prodId);
        }
        else
            throw new ProductException("Product didn't found with ID: " + prodId);
    }
}
