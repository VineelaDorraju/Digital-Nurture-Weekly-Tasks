package com.smart.product.service;

import com.smart.product.entity.Product;
import com.smart.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @Cacheable(value = "products", key = "#productId")
    public Product getProduct(String productId) {
        return repository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public boolean isAvailable(String productId, int quantity) {

        Product product = getProduct(productId);

        return Boolean.TRUE.equals(product.getAvailable())
                && product.getStock() >= quantity;
    }

    @CachePut(value = "products", key = "#productId")
    public Product updateStock(String productId, int quantity) {

        Product product = getProduct(productId);

        product.setStock(quantity);

        return repository.save(product);
    }

    @CacheEvict(value = "products", key = "#productId")
    public void deleteProduct(String productId) {

        Product product = getProduct(productId);

        repository.delete(product);
    }
}