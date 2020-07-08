package com.hktv.warehouse.repository;

import com.hktv.warehouse.entity.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LocationRepository extends CrudRepository<Location, Integer> {

    Optional<Location> findByLocation(String location);

}
