package com.hktv.warehouse.repository;

import com.hktv.warehouse.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    Optional<Product> findByCode(String code);
}
