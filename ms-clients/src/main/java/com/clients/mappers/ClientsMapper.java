package com.clients.mappers;

import com.clients.domain.Client;
import com.clients.dtos.request.ClientRequestDto;
import com.clients.dtos.response.ClientResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ClientsMapper {

    public ClientResponseDto clientEntityToResponseDto(Client clientEntity){
        ClientResponseDto responseDto = new ClientResponseDto();

        responseDto.setClientId(clientEntity.getClientId());
        responseDto.setName(clientEntity.getUserName());
        responseDto.setAddress(clientEntity.getAddress());
        responseDto.setPhoneNumber(clientEntity.getPhone());
        responseDto.setStatus(clientEntity.getStatus());

        return responseDto;
    }

    public Client requestDtoToClientEntity(ClientRequestDto requestDto){

        Client clientEntity = new Client();

        clientEntity.setUserPassword(requestDto.getPassword());
        clientEntity.setStatus(requestDto.getStatus());
        clientEntity.setAddress(requestDto.getAddress());
        clientEntity.setUserName(requestDto.getName());
        clientEntity.setPhone(requestDto.getPhoneNumber());

        return clientEntity;
    }

}
