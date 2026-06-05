package com.spring.wallet.dto;

import com.spring.wallet.domain.model.Conta;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaDTO {
    private Double saldo;
    private String chave;

    static public ContaDTO mapToDTO(Conta conta) {
        ContaDTO contaDTO = new ContaDTO();
        contaDTO.setSaldo(conta.getSaldo());
        contaDTO.setChave(conta.getChave());

        return contaDTO;
    }
}
