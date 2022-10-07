package com.ecommerce.converter;

import com.ecommerce.dto.ClientRequestDTO;
import com.ecommerce.dto.ClientResponseDTO;
import com.ecommerce.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientConverter {

    ClientConverter INSTANCE = Mappers.getMapper(ClientConverter.class);

    //for ClientResponseDTO
    Client convertClientResponseDTOToClient(ClientResponseDTO clientResponseDTO);

    ClientResponseDTO convertClientToClientResponseDTO(Client client);

    List<ClientResponseDTO> convertClientListToClientResponseDTOList(List<Client> clientResponseList);

    List<Client> convertClientResponseDTOListToClientList(List<ClientResponseDTO> clientResponseDTOList);


    //for ClientRequestDTO
//    @Mapping(target="mail", source = "mail")
    Client convertClientRequestDTOToClient(ClientRequestDTO clientRequestDTO);

    ClientRequestDTO convertClientToClientRequestDTO(Client client);

    List<ClientRequestDTO> convertClientListToClientRequestDTOList(List<Client> clientRequestList);

    List<Client> convertClientRequestDTOListToClientList(List<ClientRequestDTO> clientRequestDTOList);



}
