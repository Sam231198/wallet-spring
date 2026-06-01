package com.spring.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.wallet.domain.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findConta(String chave);
}
