package com.tech.postal_code.service.impl;

import com.tech.postal_code.exception.ResourceNotFoundException;
import com.tech.postal_code.model.Address;
import com.tech.postal_code.repository.AddressRepository;
import com.tech.postal_code.model.Client;
import com.tech.postal_code.repository.ClientRepository;
import com.tech.postal_code.service.ClientService;
import com.tech.postal_code.service.ViaCepService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
    }

    @Override
    public void insert(Client client) {
        saveClientWithCep(client);
    }

    @Override
    public void update(Long id, Client client) {
        if (clientRepository.existsById(id)) {
            saveClientWithCep(client);
        } else {
            throw new ResourceNotFoundException("Client not found with id " + id);
        }
    }

    @Override
    public void delete(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Client not found with id " + id);
        }
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
