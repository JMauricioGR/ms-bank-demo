package mappers;

import domain.Client;
import dtos.request.ClientRequestDto;
import dtos.response.ClientResponseDto;

public class ClientsMapper {

    public ClientResponseDto clientEntityToResponseDto(Client clientEntity){
        ClientResponseDto responseDto = new ClientResponseDto();

        responseDto.setName(clientEntity.getName());
        responseDto.setAddress(clientEntity.getAddress());
        responseDto.setPhoneNumber(clientEntity.getPhone());
        responseDto.setStatus(clientEntity.getStatus());

        return responseDto;
    }

    public Client requestDtoToClientEntity(ClientRequestDto requestDto){

        Client clientEntity = new Client();

        clientEntity.setPassword(requestDto.getPassword());
        clientEntity.setStatus(requestDto.getStatus());
        clientEntity.setAddress(requestDto.getAddress());
        clientEntity.setName(requestDto.getName());
        clientEntity.setPhone(requestDto.getPhoneNumber());

        return clientEntity;
    }

}
