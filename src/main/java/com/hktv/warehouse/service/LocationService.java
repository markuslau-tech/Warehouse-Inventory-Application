package com.hktv.warehouse.service;

import com.hktv.warehouse.entity.Location;
import com.hktv.warehouse.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Iterable<Location> fetchLocations() {
        return locationRepository.findAll();
    }

    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    public void removeLocation(Integer id) { locationRepository.deleteById(id); }
}
