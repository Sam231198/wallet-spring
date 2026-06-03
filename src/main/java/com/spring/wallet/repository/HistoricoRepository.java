package com.spring.wallet.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.wallet.domain.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    ArrayList<Historico> findByUsuarioId(Long usuarioId);
}
