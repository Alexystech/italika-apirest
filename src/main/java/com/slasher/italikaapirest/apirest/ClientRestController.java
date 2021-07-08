package com.slasher.italikaapirest.apirest;

import com.slasher.italikaapirest.entity.Client;
import com.slasher.italikaapirest.service.ClientService;
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
@RequestMapping("/api/client")
public class ClientRestController {

    private ClientService clientService;

    @Autowired
    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ApiOperation("To create a new client")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PostMapping("/create/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {

        if ( client == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        clientService.createClient(client);

        return ResponseEntity.ok(client);
    }

    @ApiOperation("Remove a client by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @DeleteMapping("/delete/client/{folio}")
    public ResponseEntity<Boolean> deleteClientByFolio(@PathVariable Long folio) {

        Client client = clientService.getClientByFolio(folio);

        if ( client == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        clientService.removeClientByFolio(folio);

        return ResponseEntity.ok(true);
    }

    @ApiOperation("Update a client")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No content")
    })
    @PutMapping("/update/client")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {

        if ( client == null ) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        clientService.updateClient(client);

        return ResponseEntity.ok(client);
    }

    @ApiOperation("To get a client by folio")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Client not found")
    })
    @GetMapping("/get/client/{folio}")
    public ResponseEntity<Client> getClientByFolio(@PathVariable Long folio) {

        Client client = clientService.getClientByFolio(folio);

        if ( client == null ) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(client);
    }

    @ApiOperation("To get all clients")
    @GetMapping("/get/all/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

}
