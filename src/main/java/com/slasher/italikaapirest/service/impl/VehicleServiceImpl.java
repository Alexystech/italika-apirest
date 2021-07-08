package com.slasher.italikaapirest.service.impl;

import com.slasher.italikaapirest.entity.Vehicle;
import com.slasher.italikaapirest.repository.VehicleRepository;
import com.slasher.italikaapirest.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public boolean createVehicle(Vehicle vehicle) {
        if ( vehicle != null ) {
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeVehicleByPlaque(String plaque) {
        if ( getVehicleByPlaque(plaque) != null ) {
            vehicleRepository.deleteById(plaque);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        if ( vehicle != null ) {
            vehicleRepository.save(vehicle);
            return true;
        }
        return false;
    }

    @Override
    public Vehicle getVehicleByPlaque(String plaque) {
        return vehicleRepository.findById(plaque).orElse(null);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return ((List<Vehicle>) vehicleRepository.findAll());
    }
}
