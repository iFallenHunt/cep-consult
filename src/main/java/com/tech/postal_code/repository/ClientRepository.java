package com.tech.postal_code.repository;

import com.tech.postal_code.model.Client;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findByNameContainingIgnoreCase(String name);
}
