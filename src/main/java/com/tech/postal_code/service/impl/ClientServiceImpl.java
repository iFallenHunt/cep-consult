package com.tech.postal_code.service.impl;

import com.tech.postal_code.model.Address;
import com.tech.postal_code.repository.AddressRepository;
import com.tech.postal_code.model.Client;
import com.tech.postal_code.repository.ClientRepository;
import com.tech.postal_code.service.ClientService;
import com.tech.postal_code.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> clientDb = clientRepository.findById(id);
        if (clientDb.isPresent()) {
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    private void saveClientWithCep(Client client) {
        if (client != null && client.getAddress() != null) {
            String cep = client.getAddress().getCep();
            Address address = addressRepository.findById(cep)
                    .orElseGet(() -> {
                        Address newAddress = viaCepService.consultaCep(cep);
                        addressRepository.save(newAddress);
                        return newAddress;
                    });
            client.setAddress(address);
            clientRepository.save(client);
        } else {
            throw new IllegalArgumentException("Client or Client Address cannot be null");
        }
    }
}
