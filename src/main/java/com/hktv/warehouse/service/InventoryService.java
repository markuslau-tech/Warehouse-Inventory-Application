package com.hktv.warehouse.service;

import com.hktv.warehouse.entity.*;
import com.hktv.warehouse.repository.InventoryRepository;
import com.hktv.warehouse.repository.LocationRepository;
import com.hktv.warehouse.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private LocationRepository locationRepository;

    private void updateQty(Integer productId, Integer locationId, Integer qty) {
        if ( inventoryRepository.findByProductIdAndLocationId(productId, locationId) != null ) {
            Inventory inventory = inventoryRepository.findByProductIdAndLocationId(productId, locationId);
            Integer inventoryQty = inventory.getQty();
            inventory.setQty(Integer.sum(inventoryQty, qty));
            inventoryRepository.save(inventory);

        } else {
            Inventory inventory = new Inventory();
            inventory.setProduct(productRepository.findById(productId).get());
            inventory.setLocation(locationRepository.findById(locationId).get());
            inventory.setQty(qty);
            inventoryRepository.save(inventory);
        }
    }

    public List<Inventory> getInventory(Integer productId) {
        return inventoryRepository.findByProductId(productId).stream()
                .filter(inventory -> inventory.getQty() > 0)
                .collect(Collectors.toList());
    }

    public void addInventory(List<InventoryRequest> request) {
        for(InventoryRequest invRequest : request) {
            Product product = productRepository.findByCode(invRequest.getCode()).get();
            Location location = locationRepository.findByLocation(invRequest.getLocation()).get();
            updateQty(product.getId(), location.getId(), invRequest.getQty());
        }
    }

    public void transferInventory(Integer productId, TransferRequest request) {

        Location fromLocation = locationRepository.findByLocation(request.getFrom()).get();
        Location toLocation = locationRepository.findByLocation(request.getTo()).get();

        updateQty(productId, fromLocation.getId(), -request.getQty());
        updateQty(productId, toLocation.getId(), request.getQty());
    }
}
