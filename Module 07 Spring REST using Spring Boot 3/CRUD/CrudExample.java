package com.vineela.concepts.crud;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/products")
public class CrudExample {

    static class Product {
        public Long id; public String name; public double price;
    }

    static class ProductService {
        private final Map<Long, Product> db = new ConcurrentHashMap<>();
        private final AtomicLong idGen = new AtomicLong(0);

        List<Product> findAll() { return new ArrayList<>(db.values()); }
        Product findById(Long id) { return db.get(id); }
        Product create(Product p) { p.id = idGen.incrementAndGet(); db.put(p.id, p); return p; }
        Product update(Long id, Product p) { p.id=id; db.put(id,p); return p; }
        void delete(Long id) { db.remove(id); }
    }

    private final ProductService service = new ProductService();

    @GetMapping public List<Product> all(){ return service.findAll(); }
    @GetMapping("/{id}") public Product one(@PathVariable Long id){ return service.findById(id); }
    @PostMapping public Product create(@RequestBody Product p){ return service.create(p); }
    @PutMapping("/{id}") public Product update(@PathVariable Long id, @RequestBody Product p){ return service.update(id,p); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}
