package com.hktv.warehouse.repository;

import com.hktv.warehouse.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    List<Inventory> findByProductId(Integer productId);
    Inventory findByProductIdAndLocationId(Integer productId, Integer locationId);
}
