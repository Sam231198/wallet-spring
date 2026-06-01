package com.spring.wallet.service;

import com.spring.wallet.dto.ContaDTO;

public interface OperacaoService {
    ContaDTO depositar(Long valor);
    ContaDTO sacar(Long valor);
    ContaDTO transferir(String chaveDestino, Long valor);
}
