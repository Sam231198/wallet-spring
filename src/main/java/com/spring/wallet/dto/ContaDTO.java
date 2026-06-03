package com.spring.wallet.dto;

import lombok.Getter;

@Getter
public class ContaDTO {
    private Double saldo;
    private String chave;

    public ContaDTO(Double saldo, String chave) {
        this.saldo = saldo;
        this.chave = chave;
    }
}
