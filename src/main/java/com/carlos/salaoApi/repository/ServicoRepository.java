package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
