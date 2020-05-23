package com.example.backend.service.client;

import com.example.backend.entity.dao.client.Client;
import com.example.backend.entity.dto.client.ClientDto;
import com.example.backend.entity.dto.client.ClientShortDto;
import com.example.backend.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
    @author Kacper Buczak 
*/
@Service
public class ClientService {
    private ClientRepository clientRepository;
    private ModelMapper modelMapper;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public List<ClientShortDto> getListOfClients() {
        return clientRepository
                .findAll()
                .stream()
                .map(this::entityToShortDTO)
                .collect(Collectors.toList());
    }

    public ClientDto createClient(ClientDto clientDto) {
        Client client = clientRepository.save(dtoToEntityMapper(clientDto));
        return entityToSimpleDTO(client);
    }

    public ClientDto updateClient(ClientDto clientDto) {
        Client client = clientRepository.getOne(clientDto.getId());
        client.setAddress(clientDto.getAddress());
        client.setEmail(clientDto.getEmail());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setLogin(clientDto.getLogin());
        client.setNIP(clientDto.getNIP());
        client.setPassword(clientDto.getPassword());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        return entityToSimpleDTO(clientRepository.save(client));
    }

    public boolean checkCredentials(ClientDto clientDto) {
        Client clientToCheck = clientRepository.getOne(clientDto.getId());
        return clientToCheck.getLogin().equals(clientDto.getLogin()) && clientToCheck.getPassword().equals(clientDto.getPassword());
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    private Client dtoToEntityMapper(ClientDto entity) {
        Client entityDto = modelMapper.map(entity, Client.class);
        return entityDto;
    }

    private ClientDto entityToSimpleDTO(Client entity) {
        ClientDto entityDto = modelMapper.map(entity, ClientDto.class);
        return entityDto;
    }

    private ClientShortDto entityToShortDTO(Client entity) {
        ClientShortDto entityDto = modelMapper.map(entity, ClientShortDto.class);
        return entityDto;
    }
}
