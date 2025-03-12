package com.carlos.salaoApi.repository;

import com.carlos.salaoApi.model.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    @Modifying
    @Query("DELETE FROM Horario h WHERE h.data < :hoje AND h.id NOT IN (SELECT a.id FROM Agenda a)")
    void deleteHorariosAntigosSemAgenda(@Param("hoje") LocalDate hoje);
}
