package com.clients.service;

import com.clients.dtos.request.ClientRequestDto;
import com.clients.dtos.response.ClientResponseDto;
import com.clients.mappers.ClientsMapper;
import org.springframework.stereotype.Service;
import com.clients.repository.ClientsRepository;

@Service
public class ClientsService {

    private final ClientsRepository repository;
    private final ClientsMapper mapper;

    public ClientsService(ClientsRepository repository, ClientsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClientResponseDto createClient(ClientRequestDto requestDto){
        return mapper.clientEntityToResponseDto(
                repository.save(mapper.requestDtoToClientEntity(requestDto)));
    }

    public String deleteClient(Long clientId){
        try{
            repository.deleteById(clientId);
            return "El cliente con Id: " + clientId + " ha sido borrado con éxito";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ClientResponseDto updateClient(ClientRequestDto requestDto){
        return mapper.clientEntityToResponseDto(
                repository.save(mapper.requestDtoToClientEntity(requestDto))
        );
    }

    public ClientResponseDto getClientById(Long clientId){
        return mapper.clientEntityToResponseDto(
                repository.findById(clientId).get()
        );
    }
}
