package com.hktv.warehouse.controller;

import com.hktv.warehouse.entity.Product;
import com.hktv.warehouse.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.Iterable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> fetchProducts() {
        Iterable<Product> products = productService.fetchProducts();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Product>> addProduct(@RequestBody List<Product> requests) {
        productService.addProduct(requests);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(location).body(requests);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeProduct(@PathVariable("id") Integer id) {
        productService.removeProduct(id);
        return ResponseEntity.noContent().build();
    }

}
