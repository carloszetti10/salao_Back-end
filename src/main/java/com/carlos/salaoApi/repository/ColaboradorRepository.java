package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long> {
}
