package com.tech.postal_code.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String unidade;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;
}
