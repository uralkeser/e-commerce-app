package com.ecommerce.service;

import com.ecommerce.converter.ClientConverter;
import com.ecommerce.dto.ClientRequestDTO;
import com.ecommerce.dto.ClientResponseDTO;
import com.ecommerce.entity.Client;
import com.ecommerce.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    private final ValidationService validationService;

    public List<ClientResponseDTO> getAllClients() {
        List<Client> clientList = clientRepository.findAll();
        List<ClientResponseDTO> clientResponseDTOList = ClientConverter.INSTANCE.convertClientListToClientResponseDTOList(clientList);
        log.info("requested all clients");
        return clientResponseDTOList;
    }


    public ClientResponseDTO saveClient(ClientRequestDTO clientRequestDTO) {
        Optional<Client> client = clientRepository.findByUserName(clientRequestDTO.getUserName());
        validationService.validateNoneExistentClient(client);
        Client newClient = ClientConverter.INSTANCE.convertClientRequestDTOToClient(clientRequestDTO);
        newClient = clientRepository.save(newClient);
        ClientResponseDTO clientResponseDTO = ClientConverter.INSTANCE.convertClientToClientResponseDTO(newClient);
        log.info("saved client: " + newClient.getUserName());
        return clientResponseDTO;
    }

    public ClientResponseDTO updateClient(String userName, ClientRequestDTO clientRequestDTO) {
        Optional<Client> client = clientRepository.findByUserName(userName);
        Client existingClient = validationService.validateClient(client);
        //daha iyi yol vardı yan yana setleme
        existingClient.setFullName(clientRequestDTO.getFullName());
        existingClient.setUserName(clientRequestDTO.getUserName());
        existingClient.setMail(clientRequestDTO.getMail());
        existingClient.setMobileNumber(clientRequestDTO.getMobileNumber());
        existingClient.setPassword(clientRequestDTO.getPassword());
        ClientResponseDTO clientResponseDTO = ClientConverter.INSTANCE.convertClientToClientResponseDTO(clientRepository.save(existingClient));
        log.info("updated client: " + userName);
        return clientResponseDTO;
    }

    public String deleteClientByUserName(String userName) {
        Optional<Client> client = clientRepository.findByUserName(userName);
        validationService.validateClient(client);
        clientRepository.deleteByUserName(userName);
        log.info("deleted client: " + userName);
        return "Deletion is successful";
    }


}
