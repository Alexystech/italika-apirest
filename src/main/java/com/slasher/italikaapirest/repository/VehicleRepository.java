package com.slasher.italikaapirest.repository;

import com.slasher.italikaapirest.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
}
