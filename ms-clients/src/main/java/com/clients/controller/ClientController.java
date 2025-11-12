package com.clients.controller;

import com.clients.dtos.request.ClientRequestDto;
import com.clients.dtos.response.ClientResponseDto;
import org.springframework.web.bind.annotation.*;
import com.clients.service.ClientsService;

@RestController
@RequestMapping("/api/v1/clientes/")
public class ClientController {

    private final ClientsService clientsService;

    public ClientController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    @PostMapping("create")
    public ClientResponseDto createClient(@RequestBody ClientRequestDto requestDto){
        return clientsService.createClient(requestDto);
    }

    @DeleteMapping("delete/{id}")
    public String deleteClient(@PathVariable Long id){
        return clientsService.deleteClient(id);
    }

    @PutMapping("update")
    public ClientResponseDto updateClient(@RequestBody ClientRequestDto requestDto){
        return clientsService.updateClient(requestDto);
    }

    @GetMapping("getClient/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id){
        return clientsService.getClientById(id);
    }
}
