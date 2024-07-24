package com.tech.postal_code.service;

import com.tech.postal_code.model.Client;

import java.util.List;

public interface ClientService {
    Iterable<Client> findAll();
    Client findById(Long id);
    void insert(Client client);
    void update(Long id, Client client);
    void delete(Long id);
    List<Client> findByName(String name);  // Add this line
}
