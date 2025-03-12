package com.carlos.salaoApi.controller.dto;

import com.carlos.salaoApi.model.Agenda;
import com.carlos.salaoApi.model.Cliente;
import com.carlos.salaoApi.model.Salao;
import com.carlos.salaoApi.model.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public record AgendaDTO(
        Cliente cliente,
        List<Servico> servicos,
        @JsonFormat(pattern = "HH:mm")
        LocalTime horaMarcada,
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dataMarcada
        ){
}
