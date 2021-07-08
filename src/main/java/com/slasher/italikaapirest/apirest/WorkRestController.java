package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.Work;
import com.slasher.italikaapirest.service.WorkService;
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
@RequestMapping("/api/work")
public class WorkRestController {

    private WorkService workService;

    @Autowired
    public WorkRestController(WorkService workService) {
        this.workService = workService;
    }

    @ApiOperation("create a work")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PostMapping("/create/work")
    public ResponseEntity<Work> createWork(@RequestBody Work work) {

        if ( work == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        workService.createWork(work);

        return ResponseEntity.ok(work);
    }

    @ApiOperation("delete a work by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "work not found")
    })
    @DeleteMapping("/delete/work/{folio}")
    public ResponseEntity<Boolean> deleteWorkByFolio(@PathVariable Long folio) {

        Work work = workService.getWorkByFolio(folio);

        if ( work == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        workService.removeWorkByFolio(folio);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("update a work")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PutMapping("/update/work")
    public ResponseEntity<Work> updateWork(@RequestBody Work work) {

        if ( work == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        workService.updateWork(work);

        return ResponseEntity.ok(work);
    }

    @ApiOperation("get a work by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "work not found")
    })
    @GetMapping("/get/work/{folio}")
    public ResponseEntity<Work> getWorkByFolio(@PathVariable Long folio) {

        Work work = workService.getWorkByFolio(folio);

        if ( work == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(work);
    }

    @ApiOperation("get all works")
    @GetMapping("/get/all/works")
    public ResponseEntity<List<Work>> getAllWorks() {
        List<Work> works = workService.getAllWorks();
        return ResponseEntity.ok(works);
    }

}
