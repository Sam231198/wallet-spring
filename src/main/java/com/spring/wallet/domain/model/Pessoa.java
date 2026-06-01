package com.spring.wallet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "pessoa")
@Getter
public class Pessoa {
    private String nome;
    private String cpfCnpj;
    private String email;

    public Pessoa(String nome, String cpfCnpj, String email) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
    }
}
