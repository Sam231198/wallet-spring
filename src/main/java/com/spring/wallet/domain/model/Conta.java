package com.spring.wallet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "conta")
@Getter
@Setter
public class Conta {
    private Double saldo;
    private String chave;
    private Pessoa pessoa;
}
