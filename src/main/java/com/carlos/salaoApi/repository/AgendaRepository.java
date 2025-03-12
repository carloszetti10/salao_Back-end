package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
