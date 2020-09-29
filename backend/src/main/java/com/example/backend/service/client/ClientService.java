package com.example.backend.service.client;

import com.example.backend.entity.dao.client.Client;
import com.example.backend.entity.dao.client.Role;
import com.example.backend.entity.dto.client.ClientBalanceDto;
import com.example.backend.entity.dto.client.ClientDto;
import com.example.backend.entity.dto.client.ClientShortDto;
import com.example.backend.repository.ClientRepository;
import com.example.backend.repository.RoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/*
    @author Karol Gromacki 
*/
@Service
public class ClientService {
    private ClientRepository clientRepository;
    private ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<ClientShortDto> getListOfClients() {
        return clientRepository
                .findAll()
                .stream()
                .map(this::entityToShortDTO)
                .collect(Collectors.toList());
    }

    public ClientBalanceDto getClientAccountBalance(String clientEmail) {
        Client client = clientRepository.findByEmail(clientEmail);
        return modelMapper.map(client, ClientBalanceDto.class);
    }

    @Transactional
    public ClientDto createClient(ClientDto clientDto) {
        clientDto.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        Client client = clientRepository.save(dtoToEntityMapper(clientDto));
        List<Role> defaultRoles = roleRepository.getDefaultRoles();
        client.setRoles(defaultRoles);
        defaultRoles.forEach(r -> r.addClient(client));
        roleRepository.saveAll(defaultRoles);
        return entityToSimpleDTO(clientRepository.save(client));
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
        client.setAccountBalance(clientDto.getAccountBalance());
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
        return modelMapper.map(entity, Client.class);
    }

    private ClientDto entityToSimpleDTO(Client entity) {
        return modelMapper.map(entity, ClientDto.class);
    }

    private ClientShortDto entityToShortDTO(Client entity) {
        return modelMapper.map(entity, ClientShortDto.class);
    }

}
