package com.spring.wallet.dto;

import lombok.Getter;

@Getter
public class ContaDTO {
    private Long saldo;
    private String chave;

    public ContaDTO(Long saldo, String chave) {
        this.saldo = saldo;
        this.chave = chave;
    }
}
