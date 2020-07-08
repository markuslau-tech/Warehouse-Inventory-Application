package com.hktv.warehouse.service;

import com.hktv.warehouse.entity.Product;
import com.hktv.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> fetchProducts() {
        return productRepository.findAll();
    }

    public void addProduct(List<Product> products) {
        for(Product product : products) {
            if ( productRepository.findByCode(product.getCode()).isPresent() ) {
                Product p = productRepository.findByCode(product.getCode()).get();
                p.setName(product.getName());
                p.setWeight(product.getWeight());
                productRepository.save(p);
            } else {
                productRepository.save(product);
            }
        }

    }

    public void removeProduct(Integer id) { productRepository.deleteById(id); }
}
