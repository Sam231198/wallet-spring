package com.spring.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.wallet.domain.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {
    Conta findConta(String chave);
    Conta findByCpfCnpj(String cpfCnpj);
}
