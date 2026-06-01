package com.spring.wallet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "conta")
@Getter
public class Conta {
    private Long saldo;
    private String chave;
    private Pessoa pessoa;

    public Conta(Long saldo, String chave, Pessoa pessoa) {
        this.saldo = saldo;
        this.chave = chave;
        this.pessoa = pessoa;
    }
}
