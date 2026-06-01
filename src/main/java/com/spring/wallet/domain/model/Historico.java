package com.spring.wallet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico {
    private String tipo;
    private String descricao;
    private String data;
    private Long valor;
    private Conta conta;
    
    public Historico(String tipo, String descricao, String data, Long valor, Conta conta) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.conta = conta;
    }
}
