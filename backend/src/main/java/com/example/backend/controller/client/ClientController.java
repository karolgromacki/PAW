package com.example.backend.controller.client;

import com.example.backend.entity.dto.client.ClientBalanceDto;
import com.example.backend.entity.dto.client.ClientDto;
import com.example.backend.entity.dto.client.ClientShortDto;
import com.example.backend.service.client.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    @author Karol Gromacki 
*/
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<ClientBalanceDto> getClientAccountBalance(@PathVariable Long id) {
       User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.getClientAccountBalance(user.getUsername()));
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientShortDto>> getListOfClients() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.getListOfClients());
    }

    @GetMapping(value = "/clients/credentialsCheck")
    public ResponseEntity<Boolean> getListOfClients(@RequestBody ClientDto clientDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(clientService.checkCredentials(clientDto));
    }

    @PostMapping(value = "/clients")
    public ResponseEntity<ClientDto> createClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(clientService.createClient(clientDto));
    }

    @PutMapping(value = "/clients")
    public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(clientService.updateClient(clientDto));
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }


}
