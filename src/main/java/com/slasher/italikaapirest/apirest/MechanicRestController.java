package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.Mechanic;
import com.slasher.italikaapirest.service.MechanicService;
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
@RequestMapping("/api/mechanic")
public class MechanicRestController {

    private MechanicService mechanicService;

    @Autowired
    public MechanicRestController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @ApiOperation("create a mechanic")
    @PostMapping("/create/mechanic")
    public ResponseEntity<Mechanic> createMechanic(@RequestBody Mechanic mechanic) {

        if ( mechanic == null ) {
            throw new RuntimeException("this mechanic is null");
        }

        mechanicService.createMechanic(mechanic);

        return ResponseEntity.ok(mechanic);
    }

    @ApiOperation("delete a mechanic by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Mechanic not found")
    })
    @DeleteMapping("/delete/mechanic/{folio}")
    public ResponseEntity<Boolean> deleteMechanicByFolio(@PathVariable Long folio) {

        Mechanic mechanic = mechanicService.getMechanicByFolio(folio);

        if ( mechanic == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        mechanicService.removeMechanicByFolio(folio);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("update a mechanic")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PutMapping("/update/mechanic")
    public ResponseEntity<Mechanic> updateMechanic(@RequestBody Mechanic mechanic) {

        if ( mechanic == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        mechanicService.updateMechanic(mechanic);

        return ResponseEntity.ok(mechanic);
    }

    @ApiOperation("Get a mechanic by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Mechanic not found")
    })
    @GetMapping("/get/mechanic/{folio}")
    public ResponseEntity<Mechanic> getMechanicByFolio(@PathVariable Long folio) {
        Mechanic mechanic = mechanicService.getMechanicByFolio(folio);

        if ( mechanic == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ResponseEntity.ok(mechanic);
    }

    @ApiOperation("Get all mechanics")
    @GetMapping("/get/all/mechanics")
    public ResponseEntity<List<Mechanic>> getAllMechanics() {
        List<Mechanic> mechanics = mechanicService.getAllMechanics();
        return ResponseEntity.ok(mechanics);
    }

}
