package com.spring.wallet.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "historico")
@Getter
@Setter
public class Historico {
    private String tipo;
    private String descricao;
    private String data;
    private Double valor;
    private Conta conta;
}
