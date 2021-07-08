package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.Administrator;
import com.slasher.italikaapirest.service.AdministratorService;
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
@RequestMapping("/api/administrator")
public class AdministratorRestController {

    private AdministratorService administratorService;

    @Autowired
    public AdministratorRestController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @ApiOperation("The creation of an administrator")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 405, message = "No content")
    })
    @PostMapping("/create/administrator")
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {

        if ( administrator == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        administratorService.createAdministrator(administrator);
        return ResponseEntity.ok(administrator);
    }

    @ApiOperation("End point to remove an administrator to data base")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Administrator not found")
    })
    @DeleteMapping("/delete/administrator/{folio}")
    public ResponseEntity<Boolean> deleteAdministratorByFolio(@PathVariable Long folio) {

        Administrator administrator = administratorService.getAdministratorByFolio(folio);

        if ( administrator == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        administratorService.removeAdministratorByFolio(folio);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("To update administrator")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PutMapping("/update/administrator")
    public ResponseEntity<Administrator> updateAdministrator(@RequestBody Administrator administrator) {

        if ( administrator == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        administratorService.updateAdministrator(administrator);
        return ResponseEntity.ok(administrator);
    }

    @ApiOperation("To get an administrator")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Administrator not found")
    })
    @GetMapping("/get/administrator/{folio}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long folio) {
        Administrator administrator = administratorService.getAdministratorByFolio(folio);

        if ( administrator == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(administrator);
    }

    @ApiOperation("To get all administrators")
    @GetMapping("/get/all/administrators")
    public ResponseEntity<List<Administrator>> getAlAdministrators() {
        return ResponseEntity.ok(administratorService.getAllAdministrators());
    }
}
