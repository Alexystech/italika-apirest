package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.TypeOfWork;
import com.slasher.italikaapirest.service.TypeOfWorkService;
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
@RequestMapping("/api/typeofwork")
public class TypeOfWorkRestController {

    private TypeOfWorkService typeOfWorkService;

    @Autowired
    public TypeOfWorkRestController(TypeOfWorkService typeOfWorkService) {
        this.typeOfWorkService = typeOfWorkService;
    }

    @ApiOperation("Create a type of work")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PostMapping("/create/typeofwork")
    public ResponseEntity<TypeOfWork> createTypeOfWork(@RequestBody TypeOfWork typeOfWork) {

        if ( typeOfWork == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        typeOfWorkService.createTypeOfWork(typeOfWork);

        return ResponseEntity.ok(typeOfWork);
    }

    @ApiOperation("Delete type of work by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Type of work not found")
    })
    @DeleteMapping("/delete/typeofwork/{folio}")
    public ResponseEntity<Boolean> deleteTypeOfWorkByFolio(@PathVariable Long folio) {

        TypeOfWork typeOfWork = typeOfWorkService.getTypeOfWorkByFolio(folio);

        if ( typeOfWork == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        typeOfWorkService.removeTypeOfWorkByFolio(folio);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("Update a type of work")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Type of work not found")
    })
    @PutMapping("/update/typeofwork")
    public ResponseEntity<TypeOfWork> updateTypeOfWork(@RequestBody TypeOfWork typeOfWork) {

        if ( typeOfWork == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        typeOfWorkService.updateTypeOfWork(typeOfWork);

        return ResponseEntity.ok(typeOfWork);
    }

    @ApiOperation("Get type of work by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Type of work not found")
    })
    @GetMapping("/get/typeofwork/{folio}")
    public ResponseEntity<TypeOfWork> getTypeOfWorkByFolio(@PathVariable Long folio) {

        TypeOfWork typeOfWork = typeOfWorkService.getTypeOfWorkByFolio(folio);

        if ( typeOfWork == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(typeOfWork);
    }

    @ApiOperation("Get all type of work")
    @GetMapping("/get/all/typeofwork")
    public ResponseEntity<List<TypeOfWork>> getAllTypeOfWork() {
        List<TypeOfWork> typeOfWorks = typeOfWorkService.getAllTypeOfWorks();
        return ResponseEntity.ok(typeOfWorks);
    }

}
