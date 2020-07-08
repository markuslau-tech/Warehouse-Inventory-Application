package com.hktv.warehouse.controller;

import com.hktv.warehouse.entity.Location;
import com.hktv.warehouse.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<Iterable<Location>> fetchShops() {
        Iterable<Location> locations = locationService.fetchLocations();
        return ResponseEntity.ok().body(locations);
    }

    @PostMapping("/add")
    public ResponseEntity<Location> addLocation(@RequestBody Location request) {
        Location location = new Location();
        location.setLocation(request.getLocation());
        locationService.addLocation(location);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("")
                .buildAndExpand(location.getId())
                .toUri();
        return ResponseEntity.created(uri).body(location);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity removeLocation(@PathVariable("id") Integer id) {
        locationService.removeLocation(id);
        return ResponseEntity.noContent().build();
    }

}
