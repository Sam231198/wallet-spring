package com.spring.wallet.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.wallet.domain.model.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    ArrayList<Historico> findByUsuarioId(Long usuarioId);
}
