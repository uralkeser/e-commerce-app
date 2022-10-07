package com.ecommerce.controller;

import com.ecommerce.dto.ClientRequestDTO;
import com.ecommerce.dto.ClientResponseDTO;
import com.ecommerce.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping("allClients")
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients());
    }

    @PostMapping("")
    public ResponseEntity<ClientResponseDTO> saveClient(@RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.saveClient(clientRequestDTO));
    }

    @PutMapping("{userName}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable String userName, @RequestBody ClientRequestDTO clientRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.updateClient(userName, clientRequestDTO));
    }

    @DeleteMapping("{userName}")
    public ResponseEntity<String> deleteClient(@PathVariable String userName) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clientService.deleteClientByUserName(userName));
    }
}
