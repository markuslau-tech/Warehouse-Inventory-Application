package com.hktv.warehouse.controller;

import com.hktv.warehouse.entity.Inventory;
import com.hktv.warehouse.entity.InventoryRequest;
import com.hktv.warehouse.entity.TransferRequest;
import com.hktv.warehouse.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Inventory>> getInventory(@PathVariable("id")Integer productId) {
        List<Inventory> inventories = inventoryService.getInventory(productId);
        return ResponseEntity.ok().body(inventories);
    }

    @PostMapping("/add")
    public ResponseEntity<List<InventoryRequest>> addInventory(@RequestBody List<InventoryRequest> requests) {
        inventoryService.addInventory(requests);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).body(requests);
    }

    @PutMapping("/transfer")
    public ResponseEntity<TransferRequest> transferInventory(@RequestParam("id")Integer productId, @RequestBody TransferRequest request) {
        inventoryService.transferInventory(productId, request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(uri).body(request);
    }

}
