package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.Vehicle;
import com.slasher.italikaapirest.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleRestController {

    private VehicleService vehicleService;

    @Autowired
    public VehicleRestController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @ApiOperation("create a vehicle")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PostMapping("/create/vehicle")
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {

        if ( vehicle == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        vehicleService.createVehicle(vehicle);

        return ResponseEntity.ok(vehicle);
    }

    @ApiOperation("remove a vehicle by plaque")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Vehicle not found")
    })
    @DeleteMapping("/delete/vehicle/{plaque}")
    public ResponseEntity<Boolean> deleteVehicleByFolio(@PathVariable String plaque) {

        Vehicle vehicle = vehicleService.getVehicleByPlaque(plaque);

        if ( vehicle == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        vehicleService.removeVehicleByPlaque(plaque);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("update a vehicle")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PutMapping("/update/vehicle")
    public ResponseEntity<Vehicle> updateVehicle(@RequestBody Vehicle vehicle) {

        if ( vehicle == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        vehicleService.updateVehicle(vehicle);

        return ResponseEntity.ok(vehicle);
    }

    @ApiOperation("get a vehicle by plaque")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Vehicle not found")
    })
    @GetMapping("/get/vehicle/{plaque}")
    public ResponseEntity<Vehicle> getVehicleByPlaque(@PathVariable String plaque) {

        Vehicle vehicle = vehicleService.getVehicleByPlaque(plaque);

        if ( vehicle == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(vehicle);
    }

    @ApiOperation("get all vehicles")
    @GetMapping("/get/all/vehicles")
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

}
