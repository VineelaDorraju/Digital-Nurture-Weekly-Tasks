package com.vineela.concepts.restbasics;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/api/v1/books")
public class HttpMethodsExample {

    static class Book {
        public Long id;
        public String title;
        public String author;
        public double price;

        public Book() {}
        public Book(Long id, String title, String author, double price) {
            this.id = id; this.title = title; this.author = author; this.price = price;
        }
    }

    private final Map<Long, Book> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(100);

    public HttpMethodsExample() {
        save(new Book(null, "Clean Code", "Robert C. Martin", 500));
        save(new Book(null, "Effective Java", "Joshua Bloch", 650));
    }

    private Book save(Book b) {
        if (b.id == null) b.id = idGen.incrementAndGet();
        store.put(b.id, b);
        return b;
    }

    @GetMapping
    public List<Book> getAll() {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id) {
        Book b = store.get(id);
        return b == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(b);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book b) {
        Book saved = save(b);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> replace(@PathVariable Long id, @RequestBody Book b) {
        if (!store.containsKey(id)) return ResponseEntity.notFound().build();
        b.id = id;
        store.put(id, b);
        return ResponseEntity.ok(b);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Book b = store.get(id);
        if (b == null) return ResponseEntity.notFound().build();

        updates.forEach((k, v) -> {
            switch (k) {
                case "title" -> b.title = String.valueOf(v);
                case "author" -> b.author = String.valueOf(v);
                case "price" -> b.price = Double.parseDouble(String.valueOf(v));
            }
        });
        return ResponseEntity.ok(b);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (store.remove(id) == null) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
